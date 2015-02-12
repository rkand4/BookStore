package com.bookstore.dao;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bookstore.model.User;

/**
 * 
 * @author kdhara
 *
 * All User entity related queries are handled here.
 */
@Repository("userDao")
public class UserDAOImpl extends AbstractBaseDao<User, Serializable> implements IUserDAO {
	
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	public UserDAOImpl() {
	}
	
	public User findByUsername(String userName) {
		Query q = getSession().createQuery("from User where username = ?");
		q.setParameter(0, userName);
		return (User) q.uniqueResult();
	}
}