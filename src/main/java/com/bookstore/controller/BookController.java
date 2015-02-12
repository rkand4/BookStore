package com.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.model.Book;
import com.bookstore.service.IBookService;

@Controller
public class BookController {
	private static Logger logger = Logger.getLogger(BookController.class);
	
	@Autowired
	private IBookService bookService;

	
	@RequestMapping(value = "/listBooks", method = RequestMethod.GET)
	public ModelAndView handleBookRequest() throws Exception {
		logger.debug("/listBooks executed");
		List<Book> listBooks = bookService.getAllBooks();
		ModelAndView model = new ModelAndView();
		model.addObject("bookList", listBooks);
		return model;
	}
	
	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public ModelAndView newBook() {
		logger.debug("/newBook executed");
		ModelAndView model = new ModelAndView();
		model.addObject("book", new Book());
		return model;		
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book) {
		logger.debug("/saveBook executed");
		bookService.save(book);
		return new ModelAndView("redirect:/listBooks");
	}
	
	@RequestMapping(value = "/editBook", method = RequestMethod.GET)
	public ModelAndView editBook(HttpServletRequest request) {
		logger.debug("/editBook executed");
		int bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookService.getBook(bookId);
		ModelAndView model = new ModelAndView();
		model.addObject("book", book);
		return model;		
	}
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request) {
		logger.debug("/deleteBook executed");
		int bookId = Integer.parseInt(request.getParameter("id"));
		bookService.delete(bookId);
		return new ModelAndView("redirect:/listBooks");		
	}
	
	@RequestMapping(value = "/searchBook", method = RequestMethod.GET)
	public ModelAndView searchBook(HttpServletRequest request) {
		logger.debug("/searchBook executed");
		String bookISBN = request.getParameter("isbnBook");
		if (bookISBN != null && bookISBN.length() > 0) {
			Book book = bookService.getByISBN(bookISBN);
			List<Book> books = new ArrayList<Book>();
			
			if (book != null) {
				System.out.println("Book is");
				books.add(book);
				ModelAndView model = new ModelAndView();
				model.addObject("bookList", books);
				return model;	
			}else {
				return new ModelAndView();	
			}
		}else {
			return new ModelAndView("redirect:/listBooks");	
		}		
	}

}
