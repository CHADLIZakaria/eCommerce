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
import com.chadli05.eCommerce.dao.CommentDao;
import com.chadli05.eCommerce.entities.Comment;

@Controller
@RequestMapping(path="/comments", method=RequestMethod.GET)
public class CommentController {

	@Autowired
	private CommentDao commentDao;
	@Autowired 
	private CategoryDao categoryDao;

	@RequestMapping(path="/list", method=RequestMethod.GET)
	public String showComments(Model model,
					@RequestParam(name="keyword", defaultValue = "") String keyword,
					@RequestParam(name="page", defaultValue="1") int page,
					@RequestParam(name="size", defaultValue = "5") int size) {
		Page<Comment> pageComment = commentDao.findByCommentContaining(keyword, PageRequest.of(page-1, size));
		Integer[] pages = new Integer[pageComment.getTotalPages()];
		for(int i=0; i<pages.length; i++) {
			pages[i]=i+1;
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", pages);
		model.addAttribute("comments", pageComment.getContent());
		model.addAttribute("categories", categoryDao.findAll());
		return "/comments/list-comments";
	}

}
