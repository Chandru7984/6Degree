package com.degree.subscribe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.degree.subscribe.dto.CustomerDto;
import com.degree.subscribe.dto.CustomerLoginDto;
import com.degree.subscribe.entity.Customer;
import com.degree.subscribe.repository.CustomerRepository;
import com.degree.subscribe.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/Subscriber")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerService customerService;

	@PostMapping("/signup")
	public ResponseEntity<Object> register(@RequestBody CustomerDto customerDto) {
		if (Objects.isNull((customerDto.getEmail()))) {
			return new ResponseEntity<>("Email cannot be empty", HttpStatus.BAD_REQUEST);
		}
		if (customerRepository.existsByEmail(customerDto.getEmail())) {
			return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
		}
		if (Objects.isNull(customerDto.getMobile())) {
			return new ResponseEntity<>("Mobile number cannot be empty", HttpStatus.BAD_REQUEST);
		}
		if (customerRepository.existsByMobile(customerDto.getMobile())) {
			return new ResponseEntity<>("Mobile number already exists", HttpStatus.BAD_REQUEST);
		}
		if (Objects.isNull(customerDto.getPassword())) {
			return new ResponseEntity<>("Password cannot be empty", HttpStatus.BAD_REQUEST);
		}
		if (!(customerDto.getPassword().equals(customerDto.getConfirmpassword()))) {
			return new ResponseEntity<>("Password is not matched", HttpStatus.BAD_REQUEST);
		}
		customerService.saveCustomer(customerDto);

		Map<String, String> success = new HashMap<>();
		success.put("success", "Signup Successful!");

		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	@PostMapping("/signin")
	public ResponseEntity<Object> signIn(@RequestBody CustomerLoginDto loginDto) {

		Optional<Customer> findByEmail = customerRepository.findByEmail(loginDto.getEmail());
		
		if (findByEmail.isPresent()) {
			return customerService.findByEmailAndPassword(loginDto);
		}

		Map<String, String> error = new HashMap<>();
		error.put("error", "Invalid Email Address");
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/customer/{designerid}")
	public ResponseEntity<List<Customer>> getCustomerDetails(@PathVariable("designerid") Long designerid) {
		List<Customer> customer = customerRepository.getCustomerByDesignerId(designerid);
		return ResponseEntity.ok(customer);
	}
}
