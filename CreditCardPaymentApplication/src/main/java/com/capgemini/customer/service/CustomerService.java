package com.capgemini.customer.service;

import java.util.List;

import com.capgemini.customer.entity.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	void removeCustomer(long custId);
	Customer updateCustomer(long custId, Customer customer);
	Customer getCustomer(long custId);
	List<Customer> getAllCustomer();

}
