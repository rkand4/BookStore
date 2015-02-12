package com.bookstore.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.bookstore.model.Customer;

@Repository("customerDao")
public class CustomerDAO extends AbstractBaseDao<Customer, Serializable> implements ICustomerDAO {

	
}
