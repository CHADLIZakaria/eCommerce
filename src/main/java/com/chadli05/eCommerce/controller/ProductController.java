package com.chadli05.eCommerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import com.chadli05.eCommerce.dao.CategoryDao;
import com.chadli05.eCommerce.dao.ProductDao;
import com.chadli05.eCommerce.entities.Category;
import com.chadli05.eCommerce.entities.Product;
import com.chadli05.eCommerce.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "/products", method = RequestMethod.GET)
public class ProductController {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private CategoryDao categoryDao;

	public static String uploadsDirectory = System.getProperty("user.dir") + "/uploads";

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showProducts(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Page<Product> pageProduct = productDao.findByNameContaining(keyword, PageRequest.of(page, size));

		Integer[] listPages = new Integer[pageProduct.getTotalPages()];
		for (int i = 0; i < listPages.length; i++) {
			listPages[i] = i;
		}

		model.addAttribute("pages", listPages);
		model.addAttribute("products", pageProduct.getContent());
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", keyword);
		model.addAttribute("categories", categoryDao.findAll());
		return "/products/list-products";
	}

	@RequestMapping(path = "/addProduct", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("categories", categoryDao.findAll());
		model.addAttribute("product", new Product());
		return "/products/product-form";
	}

	@RequestMapping(path = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(Model model, @ModelAttribute("product") Product product,
			@RequestParam("photoProduct") MultipartFile file) {
		model.addAttribute("categories", categoryDao.findAll());
		Path fileNameAndPath = Paths.get(uploadsDirectory, file.getOriginalFilename());
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		product.setUser(new User());
		product.setCategory(new Category());
		product.setPhoto(file.getOriginalFilename());
		productDao.save(product);
		return "redirect:/products/list";
	}

	@RequestMapping(path="/editProduct", method=RequestMethod.GET) 
	public String editProduct(Model model 
	,@RequestParam("idProduct") Long idProduct
	) {
		
		Optional<Product> result = productDao.findById(idProduct);
		if(result.isPresent()) {
			Product product = result.get();
			model.addAttribute("product", product);
			return "/products/product-form";
		}
		else {
			return "/products/product-form";
		}
	}

}
