package org.chrismaloney.service;

import java.util.List;

import org.chrismaloney.model.Customer;

public interface CustomerService {

	public abstract List<Customer> findAll();

}