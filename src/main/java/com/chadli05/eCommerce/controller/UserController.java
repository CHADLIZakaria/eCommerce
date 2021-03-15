package com.chadli05.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chadli05.eCommerce.dao.CategoryDao;
import com.chadli05.eCommerce.dao.UserDao;
import com.chadli05.eCommerce.entities.User;

@Controller
@RequestMapping(path="/users", method=RequestMethod.GET)
public class UserController {
	@Autowired 
	private UserDao userDao;
	@Autowired 
	private CategoryDao categoryDao;
	
	@RequestMapping(path="/list", method=RequestMethod.GET)
	public String showMembers(Model model,
						@RequestParam(name="keyword", defaultValue="") String keyword,
						@RequestParam(name="page", defaultValue="1") int page,
						@RequestParam(name="size", defaultValue="5") int size) {
		Page<User> userPage= userDao.findByUsernameContaining(keyword, PageRequest.of(page-1, size));
		Integer[] pages = new Integer[userPage.getTotalPages()];
		for(int i = 0; i < pages.length; i++) {
			pages[i]=i+1;
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("myPages", pages);
		model.addAttribute("users", userPage.getContent());
		model.addAttribute("categories", categoryDao.findAll());
		return "/users/list-users";
	}
}
