package com.virtusa.precalc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtusa.precalc.model.CustomerModel;
import com.virtusa.precalc.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerModel saveCustomer(CustomerModel customer) {
		return customerRepository.save(customer);
	}

	public CustomerModel findByEmail(String customerEmail) {
		return customerRepository.findByCustomerEmail(customerEmail);
	}

	public CustomerModel findByEmailandPass(String customerEmail, String customerPassword) {
		return customerRepository.findByCustomerEmailAndCustomerPassword(customerEmail, customerPassword);
	}

	public List<CustomerModel> findAllCustomers() {
		return customerRepository.findAll();
	}

	public CustomerModel findCustomerById(int customerId) {
		return customerRepository.findByCustomerId(customerId);
	}

	public CustomerModel saveUpdatedCustomer(CustomerModel cm) {
		return customerRepository.save(cm);
	}

}
