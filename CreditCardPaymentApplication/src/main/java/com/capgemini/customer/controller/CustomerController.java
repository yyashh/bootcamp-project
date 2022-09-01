package com.capgemini.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
//	@RequestMapping("/customer")
//	public String hello() {
//		System.out.println("hello");
//		return "hello";
//	}
	
	@GetMapping("/customers")
	public  List<Customer> listCustomers() {
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/customers/{custId}")
	public Customer  getCustomerbyid(@PathVariable long custId) {
		return customerService.getCustomer(custId);
	}
	
	@PostMapping("/addcustomer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@PostMapping("/updatecustomer/{custId}")
	public Customer updateCust(@PathVariable long custId, @RequestBody Customer customer) {
		
		Customer existingCustomer = customerService.getCustomer(custId);
		existingCustomer.setUserId(custId);
		existingCustomer.setName(customer.getName());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setContactNo(customer.getContactNo());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setLocalDate(customer.getLocalDate());
		
		return customerService.updateCustomer(custId, existingCustomer);
	}
	
	@GetMapping("/deletecustomer/{custId}")
	public String deleteCustomer(@PathVariable long custId) {
		customerService.removeCustomer(custId);
		return "deleted";
	}
	

}
