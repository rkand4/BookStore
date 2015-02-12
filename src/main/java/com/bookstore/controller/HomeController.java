package com.bookstore.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.dao.IBookDAO;
import com.bookstore.dao.IUserDAO;

/**
 * 
 * @author kdhara
 * 
 * Root controller of the application, all request uri's are mapped to corresponding
 * model and views
 *
 */
@Controller
public class HomeController {
	
	private static Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private IUserDAO userDao;
	
	@Autowired
	private IBookDAO bookDao;
	
	@RequestMapping(value="/")
	public String home(ModelMap model) {
		System.out.print("*****");
		logger.debug("welcome page");
		return "home";
	}
	@RequestMapping(value="/login")
	public String login(ModelMap model) {
		System.out.print("*****");
		logger.debug("welcome page");
		return "login";
	}
 
	@RequestMapping(value="/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		logger.debug("/welcome/ executed");
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - " + name);
		return "index";
 	}
	
	@RequestMapping(value="/about")
	public String about(ModelMap model) {
		System.out.print("*****");
		logger.debug("about page");
		return "about";
	}
	
	@RequestMapping(value="/contact")
	public String contact(ModelMap model) {
		System.out.print("*****");
		logger.debug("contact page");
		return "contact";
	}
	
	
}
