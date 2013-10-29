package org.chrismaloney.service;

import java.util.List;

import org.chrismaloney.model.Customer;
import org.chrismaloney.repository.CustomerRepository;
import org.chrismaloney.repository.HibernateCustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	// Autowire at the member variable level, initially.  Only switch to
	// wiring at the setter if needed.
	//@Autowired
	private CustomerRepository customerRepository;
	
	// You'll need a no-args constructor if you use setter injection.
	public CustomerServiceImpl() {
	}
	
	
	// Constructor injection
	//@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("We are using constructor injection");
		this.customerRepository = customerRepository;
	}
	
	// Here is setter injection
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We are using setter injection");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}
