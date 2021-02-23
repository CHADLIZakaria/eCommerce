package com.chadli05.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chadli05.eCommerce.dao.ProductDao;
import com.chadli05.eCommerce.entities.Product;


@Controller
@RequestMapping(path="/products", method = RequestMethod.GET)
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping(path="/list")
	public String showProducts(Model model,
								@RequestParam(name="page", defaultValue = "0") int page,
								@RequestParam(name="size", defaultValue="5") int size) {
		Page<Product> pageProduct= productDao.findAll(PageRequest.of(page, size));
		
		Integer[] listPages = new Integer[pageProduct.getTotalPages()];
		for(int i=0; i<listPages.length; i++) {
			listPages[i]=i;
		}
	
		model.addAttribute("pages", listPages);
		model.addAttribute("products", pageProduct.getContent());
		return "/products/list-products";
	}
	
	
}
