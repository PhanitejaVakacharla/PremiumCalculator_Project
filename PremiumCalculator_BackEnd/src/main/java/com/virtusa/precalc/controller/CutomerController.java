package com.virtusa.precalc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.precalc.model.LoginModel;
import com.virtusa.precalc.exception.BadCredentialsException;
import com.virtusa.precalc.exception.EmailAlreadyExistsException;
import com.virtusa.precalc.exception.PasswordMismatchException;
import com.virtusa.precalc.model.CustomerModel;
import com.virtusa.precalc.service.CustomerService;

@RestController
public class CutomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<CustomerModel> createPolicy(@RequestBody CustomerModel customer) {
		String password = customer.getCustomerPassword();
		String confirmPassword = customer.getCustomerConfirmPassword();
		CustomerModel cust = customerService.findByEmail(customer.getCustomerEmail());
		if (cust == null) {
			if (password.equals(confirmPassword)) {
				//return customerService.saveCustomer(customer);
				CustomerModel customers = customerService.saveCustomer(customer);
				return new ResponseEntity<CustomerModel>(customers, HttpStatus.OK);
			}
			else
				throw new PasswordMismatchException("Password and Confirm Password do not match.");
		} else
			throw new EmailAlreadyExistsException("This email Id already exists");
	}

	@PostMapping("/login")
	public String Authorize(@RequestBody LoginModel data) {
		String email = data.getEmail();
		String password = data.getPassword();
		if (email.equals("admin@gmail.com") && password.equals("admin")) {
			return "Welcome Admin";
		} else {
			CustomerModel cust = customerService.findByEmailandPass(email, password);
			if (cust != null) {
				return "Welcome User";
			} else
				throw new BadCredentialsException("Invalid Username or Password");
		}

	}

}
