package com.virtusa.precalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.precalc.model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {

	CustomerModel findByCustomerEmail(String customerEmail);

	CustomerModel findByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);

	CustomerModel findByCustomerId(int customerId);

}
