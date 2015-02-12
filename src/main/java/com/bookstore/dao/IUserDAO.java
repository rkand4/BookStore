package com.bookstore.dao;

import java.io.Serializable;

import com.bookstore.model.User;


public interface IUserDAO extends BaseDao<User, Serializable>{
	
	public User findByUsername(String userName);
}