package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.IBookDAO;
import com.bookstore.model.Book;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private IBookDAO bookDAO;
	
	public Book getByISBN(String isbn) {
		return bookDAO.getByISBN(isbn);
	}

	public List<Book> getByAuthor(String author) {
		return bookDAO.getByAuthor(author);
	}

	public List<Book> getAllBooks() {
		return bookDAO.getList();
	}

	public Book getBook(int bookId) {
		return bookDAO.get((long) bookId);
	}

	public void save(Book book) {
		bookDAO.save(book);
		
	}

	public void update(Book book) {
		bookDAO.update(book);
	}

	public void delete(Book book) {
		bookDAO.delete(book);
	}

	public void delete(int id) {
		bookDAO.deleteById((long) id);
		
	}

}
