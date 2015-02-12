package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.IUserDAO;
import com.bookstore.model.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDAO;

	public List<User> getAllUsers() {
		return userDAO.getList();
	}

	public User getUser(int id) {
		return userDAO.get((long) id);
	}

	public void save(User user) {
		userDAO.save(user);

	}

	public void delete(int id) {
		userDAO.deleteById((long) id);

	}

	public void update(User user) {
		userDAO.update(user);

	}

	public User findByUsername(String userName) {
		return userDAO.findByUsername(userName);
	}

}
