package com.chadli05.eCommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHome() {
		return "redirect:/products/list";
	}
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String showDashboard() {
		return "dashboard";
	}
}
