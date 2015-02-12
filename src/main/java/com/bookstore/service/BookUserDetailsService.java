package com.bookstore.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.dao.IUserDAO;
import com.bookstore.model.BookUserDetails;
import com.bookstore.model.User;
import com.bookstore.transformer.BookUserdetailsTransformer;
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)

public class BookUserDetailsService implements UserDetailsService {
	private static Log logger = LogFactory.getLog(BookUserDetailsService.class);

	@Autowired
	private IUserDAO userDao ;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		logger.info("the username is "+username);
	User user=	userDao.findByUsername(username);
	logger.info("the user object is "+user);
	//TODO: Change this to use underlying USER table of database
	User userMock = new User();
	userMock.setDisplayName("BookStoreAdmin");
	userMock.setUsername("admin");
	userMock.setEnabled(true);
	userMock.setPassword("admin");
	userMock.setEmail("bookstoreadmin@gmail.com");
	userMock.setUserId(1);
	BookUserDetails bookUserDetails = new BookUserdetailsTransformer().transformFromUserToMamosUserDetails(userMock);
	return bookUserDetails;
	}
	
	
	

}
