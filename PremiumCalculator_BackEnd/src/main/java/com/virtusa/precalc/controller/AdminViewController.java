package com.virtusa.precalc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.precalc.exception.CustomerNotFoundException;
import com.virtusa.precalc.model.CustomerModel;
import com.virtusa.precalc.service.CustomerService;

@RestController
@RequestMapping("/admin")
public class AdminViewController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/getCustomers")
	public ResponseEntity<List<CustomerModel>> getCustomers() {
		List<CustomerModel> customers = customerService.findAllCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	// update customer by id
	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<CustomerModel> updatePolicy(@PathVariable int customerId,
			@RequestBody CustomerModel customerDetails) {
		CustomerModel cm = customerService.findCustomerById(customerId);
		if (cm != null) {
			cm.setCustomerName(customerDetails.getCustomerName());
			cm.setCustomerMobile(customerDetails.getCustomerMobile());

			CustomerModel updateCustomer = customerService.saveUpdatedCustomer(cm);
			return ResponseEntity.ok(updateCustomer);
		} else
			throw new CustomerNotFoundException("Customer Not found with policy Id as: " + customerId);
	}


}
