package com.bookstore.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Book;

/**
 * 
 * @author kdhara
 *
 * All Book entity related queries are handled here.
 */
@Repository("bookDao")
public class BookDAOImpl extends AbstractBaseDao<Book, Serializable> implements IBookDAO {
	
	private static Logger logger = Logger.getLogger(BookDAOImpl.class);
	
	
	public BookDAOImpl() {
		
	}
	
	public Book getByISBN(String isbn) {
		String hql = "from Book where bookISBN like '"+ isbn+"'";
		Query query = getSession().createQuery(hql);
		logger.debug("Query is "+ query +"Query list size is "+query.list().size());
		if(query != null && query.list().size() > 0) {
			@SuppressWarnings("unchecked")
			List<Book> listBook = (List<Book>) query.list();
			
			if (listBook != null && !listBook.isEmpty()) {
				return listBook.get(0);
			}
		}
		return null;
	}
	public List<Book> getByAuthor(String author) {
		String hql = "from Book where author like '"+ author+"'";
		Query query = getSession().createQuery(hql);
		List<Book> listBooks = query.list();
		logger.debug("Query is "+ query +"Query list size is "+listBooks.size());
		
		return listBooks;
	}
}