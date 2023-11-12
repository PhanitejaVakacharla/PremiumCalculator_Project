package com.virtusa.precalc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.precalc.model.LoginModel;
import com.virtusa.precalc.dto.AdminModelDto;
import com.virtusa.precalc.dto.CustomerModelDto;
import com.virtusa.precalc.exception.BadCredentialsException;
import com.virtusa.precalc.exception.EmailAlreadyExistsException;
import com.virtusa.precalc.exception.InvalidCredentialsForAdminException;

import com.virtusa.precalc.model.CustomerModel;
import com.virtusa.precalc.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<CustomerModel> createPolicy(@RequestBody CustomerModelDto customerDto) {

		CustomerModel cust = customerService.findByEmail(customerDto.getEmail());

		if (cust == null) {

			CustomerModel c = new CustomerModel();
			c.setCustomerConfirmPassword(customerDto.getConfirmpassword());
			c.setCustomerEmail(customerDto.getEmail());
			c.setCustomerMobile(customerDto.getMobilenumber());
			c.setCustomerName(customerDto.getUsername());
			c.setCustomerPassword(customerDto.getPassword());
			c.setRole(customerDto.getRole());

			CustomerModel customers = customerService.saveCustomer(c);
			return new ResponseEntity<>(customers, HttpStatus.OK);
		}

		else
			throw new EmailAlreadyExistsException("This email Id already exists");
	}

	@PostMapping("/saveAdmin")
	public ResponseEntity<CustomerModel> createPolicy(@RequestBody AdminModelDto adminDto) {

		CustomerModel cust = customerService.findByEmail(adminDto.getEmail());

		if (cust == null) {

			CustomerModel c = new CustomerModel();
			c.setCustomerConfirmPassword(adminDto.getConfirmpassword());
			c.setCustomerEmail(adminDto.getEmail());
			c.setCustomerMobile(adminDto.getMobilenumber());
			c.setCustomerName(adminDto.getUsername());
			c.setCustomerPassword(adminDto.getPassword());
			c.setRole(adminDto.getRole());

			CustomerModel customers = customerService.saveCustomer(c);
			return new ResponseEntity<>(customers, HttpStatus.OK);
		}

		else
			throw new EmailAlreadyExistsException("This email Id already exists");
	}

	@PostMapping("/login")
	public String authorize(@RequestBody LoginModel data) {
		String email = data.getEmail();
		String password = data.getPassword();

		CustomerModel cust = customerService.findByEmailandPass(email, password);

		if (cust != null && cust.getRole().equals("user")) {
			return "Welcome User";
		} else
			throw new BadCredentialsException("Invalid Username or Password");

	}

	@PostMapping("/adminLogin")
	public String adminLogin(@RequestBody LoginModel data) {
		String email = data.getEmail();
		String password = data.getPassword();

		CustomerModel cust = customerService.findByEmailandPass(email, password);

		if (cust != null && cust.getRole().equals("admin")) {
			return "Welcome Admin";
		} else
			throw new InvalidCredentialsForAdminException("Invalid Username or password for admin");
	}
}
