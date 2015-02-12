package com.bookstore.dao;

import java.io.Serializable;
import java.util.List;

import com.bookstore.model.Book;


public interface IBookDAO extends BaseDao<Book, Serializable> {
	public Book getByISBN(String isbn);
	public List<Book> getByAuthor(String author);
}