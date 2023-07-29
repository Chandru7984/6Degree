package com.degree.subscribe.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import com.degree.subscribe.dto.CustomerDto;
import com.degree.subscribe.dto.CustomerLoginDto;
import com.degree.subscribe.entity.Customer;
import com.degree.subscribe.entity.CustomerAddress;
import com.degree.subscribe.repository.CustomerAddRepository;
import com.degree.subscribe.repository.CustomerRepository;
import com.degree.subscribe.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerAddRepository addRepository;

	@Override
	public Customer saveCustomer(CustomerDto customerDto) {

		Customer customer = new Customer();

		CustomerAddress address = new CustomerAddress();

		String seq = "secure"; // secret key used by password encoding
		Integer saltLength = 64; // salt length in bytes
		Integer iterations = 200000; // number of hash iteration
		Integer hashWidth = 256; // hash width in bits

		if (Objects.nonNull(customerDto.getFullname()) && !customerDto.getFullname().isEmpty()) {
			customer.setFullname(customerDto.getFullname());
		}
		customer.setEmail(customerDto.getEmail());
		customer.setPassword(customerDto.getPassword());
		if (Objects.nonNull(customerDto.getMobile()) && !customerDto.getMobile().isEmpty()) {
			customer.setMobile(customerDto.getMobile());
		}
		customer.setDesignerid(customerDto.getDesignerid());

		PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(seq, saltLength, iterations, hashWidth);
		String encode = passwordEncoder.encode(customerDto.getPassword());
		customer.setPassword(encode);

		customerRepository.saveAndFlush(customer);

		if (Objects.nonNull(customerDto.getName()) && !customerDto.getName().isEmpty()) {
			address.setName(customerDto.getName());
		}
		if (Objects.nonNull(customerDto.getAddressline1()) && !customerDto.getAddressline1().isEmpty()) {
			address.setAddressline1(customerDto.getAddressline1());
		}
		if (Objects.nonNull(customerDto.getAddressline2()) && !customerDto.getAddressline2().isEmpty()) {
			address.setAddressline2(customerDto.getAddressline2());
		}
		if (Objects.nonNull(customerDto.getLandmark()) && !customerDto.getLandmark().isEmpty()) {
			address.setLandmark(customerDto.getLandmark());
		}
		if (Objects.nonNull(customerDto.getCity()) && !customerDto.getCity().isEmpty()) {
			address.setCity(customerDto.getCity());
		}
		if (Objects.nonNull(customerDto.getState()) && !customerDto.getState().isEmpty()) {
			address.setState(customerDto.getState());
		}
		if (Objects.nonNull(customerDto.getCountry()) && !customerDto.getCountry().isEmpty()) {
			address.setCountry(customerDto.getCountry());
		}
		if (Objects.nonNull(customerDto.getPincode()) && !customerDto.getPincode().isEmpty()) {
			address.setPincode(customerDto.getPincode());
		}
		if (Objects.nonNull(customerDto.getDescription()) && !customerDto.getDescription().isEmpty()) {
			address.setDescription(customerDto.getDescription());
		}
		address.setCustomerid(customerDto.getCustomerid());
		address.setIsdefault(1);
		address.setCustomerid(customer.getId());

		addRepository.saveAndFlush(address);

		return customer;

	}

	@Override
	public ResponseEntity<Object> findByEmailAndPassword(CustomerLoginDto loginDto) {

		Customer customer = customerRepository.findByEmail(loginDto.getEmail()).get();

		String seq = "secure"; // secret key used by password encoding
		Integer saltLength = 64; // salt length in bytes
		Integer iterations = 200000; // number of hash iteration
		Integer hashWidth = 256; // hash width in bits

		PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(seq, saltLength, iterations, hashWidth);
		boolean encode = passwordEncoder.matches(loginDto.getPassword(), customer.getPassword());

		if (encode) {

			Map<String, String> success = new HashMap<>();
			success.put("Sucess", "Signin Successful!");
			
			return new ResponseEntity<>(success, HttpStatus.OK);
		}

		Map<String, String> error = new HashMap<>();
		error.put("error", "Incorrect Password");

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	public List<Customer> getCustomerByDesignerId(Long designerid) {
		return this.customerRepository.getCustomerByDesignerId(designerid);
	}

	@Override
	public ResponseEntity<Object> updateResetPasswordToken(String email, String token) {
		Optional<Customer> customerDetails = customerRepository.findByEmail(email);

//		ResponseEntity<Object> resp = new ResponseEntity<Object>(HttpStatus.OK);

		if (customerDetails.isPresent()) {
			customerDetails.get().setResetpasswordtoken(token);
			customerRepository.saveAndFlush(customerDetails.get());

			Map<String, String> success = new HashMap<>();
			success.put("Success", "Token Generated");
			return new ResponseEntity<>(success, HttpStatus.OK);

		} else {

			Map<String, String> error = new HashMap<>();
			error.put("Error", "Invalid Customer email Or Customer not found");
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Customer getToken(String resetpasswordtoken) {
		return customerRepository.findByResetpasswordtoken(resetpasswordtoken);
	}

	@Override
	public void updatePassword(Customer customer, String newPassword) {

		String seq = "secure";
		Integer saltLength = 64;
		Integer iterations = 200000;
		Integer hashWidth = 256;

		PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(seq, saltLength, iterations, hashWidth);
		String encode = passwordEncoder.encode(newPassword);

		customer.setPassword(encode);
		customer.setResetpasswordtoken(null);

		customerRepository.save(customer);
	}

}
