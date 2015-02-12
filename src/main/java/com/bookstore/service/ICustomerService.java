package com.bookstore.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.model.Customer;

@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public interface ICustomerService {

	public List<Customer> getAllCustomers();

	public Customer getCustomer(int customerId);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Customer customer);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(Customer customer);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Customer customer);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(int id);

}
