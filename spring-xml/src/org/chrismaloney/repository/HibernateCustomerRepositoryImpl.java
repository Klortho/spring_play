package org.chrismaloney.repository;

import java.util.ArrayList;
import java.util.List;

import org.chrismaloney.model.Customer;


public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	/* (non-Javadoc)
	 * @see org.chrismaloney.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();
		
		Customer customer = new Customer();
		customer.setGivenName("Fred");
		customer.setFamilyName("Johnson");
		customers.add(customer);
		
		return customers;
	}

}
