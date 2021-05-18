package com.chadli05.eCommerce.controller;

import com.chadli05.eCommerce.dao.CategoryDao;
import com.chadli05.eCommerce.dao.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;

	@RequestMapping(path = "/category", method = RequestMethod.GET)
	public String showProductsByCategory(@RequestParam("id") Long id, Model model) {
		model.addAttribute("categories", categoryDao.findAll());
		model.addAttribute("products", productDao.findAllByCategoryId(id));
		return "/categories/list-items-by-categorie";
	}
}
