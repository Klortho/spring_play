package org.chrismaloney.service;

import java.util.List;

import org.chrismaloney.model.Customer;
import org.chrismaloney.repository.CustomerRepository;
import org.chrismaloney.repository.HibernateCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();
	
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}
