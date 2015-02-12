package com.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.model.Customer;
import com.bookstore.service.ICustomerService;
@Controller
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	private static Logger logger = Logger.getLogger(CustomerController.class);

	
	@RequestMapping(value = "/listCustomers", method = RequestMethod.GET)
	public ModelAndView getAllCustomers() throws Exception {
		logger.debug("/listCustomers  executed");
		List<Customer> listCustomers = customerService.getAllCustomers();
		ModelAndView model = new ModelAndView("customerList");
		model.addObject("customerList", listCustomers);
		return model;
	}
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public ModelAndView newCustomer() {
		logger.debug("/newCustomer executed");
		ModelAndView model = new ModelAndView();
		model.addObject("customer", new Customer());
		return model;		
	}
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editCustomer(HttpServletRequest request) {
		logger.debug("/editUser executed");
		int userId = Integer.parseInt(request.getParameter("customerId"));
		Customer customer = customerService.getCustomer(userId);
		ModelAndView model = new ModelAndView();
		model.addObject("customer", customer);
		return model;		
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		logger.debug("/deleteCustomer executed");
		int userId = Integer.parseInt(request.getParameter("customerId"));
		customerService.delete(userId);
		return new ModelAndView("redirect:/listCustomers");		
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Customer customer) {
		logger.debug("/saveUser executed");
		customerService.save(customer);
		return new ModelAndView("redirect:/listCustomers");
	}

}
