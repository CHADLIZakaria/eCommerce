package com.chadli05.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chadli05.eCommerce.dao.ProductDao;


@Controller
@RequestMapping(path="/products", method = RequestMethod.GET)
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping(path="/list")
	public String showProducts(Model model) {
		model.addAttribute("products", productDao.findAll());
		return "/products/list-products";
	}
	
	
}
