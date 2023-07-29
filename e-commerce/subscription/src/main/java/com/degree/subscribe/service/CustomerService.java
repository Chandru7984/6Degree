package com.degree.subscribe.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.degree.subscribe.dto.CustomerDto;
import com.degree.subscribe.dto.CustomerLoginDto;
import com.degree.subscribe.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(CustomerDto customerDto);

	ResponseEntity<Object> findByEmailAndPassword(CustomerLoginDto loginDto);
	
	List<Customer> getCustomerByDesignerId(Long designerid);
	
	ResponseEntity<Object> updateResetPasswordToken(String email, String token);
	
	Customer getToken(String resetpasswordtoken);
	
	void updatePassword(Customer customer, String newPassword);

}
