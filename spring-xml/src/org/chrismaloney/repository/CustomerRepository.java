package org.chrismaloney.repository;

import java.util.List;

import org.chrismaloney.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}