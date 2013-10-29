package org.chrismaloney.repository;

import java.util.ArrayList;
import java.util.List;

import org.chrismaloney.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;


// This annotation "wires" this implementation to the interface.
// By convention, this should be named the same as the interface, but with a lowercase
// initial letter.

@Repository("customerRepository")

public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	@Value("${someProperty}")
	private String someValue;

	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();
		
		Customer customer = new Customer();
		customer.setGivenName(someValue);
		customer.setFamilyName("Johnson");
		customers.add(customer);
		
		return customers;
	}

}
