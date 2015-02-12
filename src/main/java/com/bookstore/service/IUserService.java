package com.bookstore.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.model.User;

@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public interface IUserService {

	public List<User> getAllUsers();

	public User getUser(int id);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(User user);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(int id);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(User user);

	public User findByUsername(String userName);
}
