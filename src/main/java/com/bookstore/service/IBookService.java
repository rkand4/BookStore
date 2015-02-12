package com.bookstore.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.model.Book;

@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public interface IBookService {

	public Book getByISBN(String isbn);

	public List<Book> getByAuthor(String author);

	public List<Book> getAllBooks();

	public Book getBook(int bookId);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Book book);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(Book book);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Book book);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(int id);

}
