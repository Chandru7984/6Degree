package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.CustomerLoginDto;
import com.example.demo.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(CustomerDto customerDto);

	ResponseEntity<String> findByEmailAndPassword(CustomerLoginDto loginDto);
	
	List<Customer> getCustomerByDesignerId(Long designerid);
	
	ResponseEntity<Object> updateResetPasswordToken(String email, String token);
	
	Customer getToken(String resetpasswordtoken);
	
	void updatePassword(Customer customer, String newPassword);

}
