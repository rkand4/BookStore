package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.ICustomerDAO;
import com.bookstore.model.Customer;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerDAO customerDAO;

	public List<Customer> getAllCustomers() {
		return customerDAO.getList();
	}

	public Customer getCustomer(int customerId) {
		return customerDAO.get((long) customerId);
	}

	public void save(Customer customer) {
		customerDAO.save(customer);

	}

	public void update(Customer customer) {
		customerDAO.update(customer);
	}

	public void delete(Customer customer) {
		customerDAO.delete(customer);
	}

	public void delete(int id) {
		customerDAO.deleteById((long) id);
		
	}

}
