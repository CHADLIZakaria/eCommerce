package com.chadli05.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chadli05.eCommerce.dao.CategoryDao;

@Controller
public class HomeController {
	@Autowired
	private CategoryDao categoriesDao;
	
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHome(Model model) {
		model.addAttribute("categories", categoriesDao.findAll());
		return "redirect:/products/list";
	}
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String showDashboard(Model model) {
		model.addAttribute("categories", categoriesDao.findAll());
		return "dashboard";
	}
}
