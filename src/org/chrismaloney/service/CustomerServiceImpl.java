package org.chrismaloney.service;

import java.util.List;

import org.chrismaloney.model.Customer;
import org.chrismaloney.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	// Default constructor lets us use setter injection if we want to
	public CustomerServiceImpl() {
	}
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("Inside CustomerServiceImpl constructor");
		this.customerRepository = customerRepository;
	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("Inside CustomerServiceImpl customerRepository setter");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}
