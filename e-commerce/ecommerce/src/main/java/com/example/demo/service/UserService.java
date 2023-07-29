package com.example.demo.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Designer;

public interface UserService {

	Designer saveUser(UserDto userDto);
	
	ResponseEntity<Object> findByEmailAndPassword(LoginDto loginDto);

	ResponseEntity<Object> verifyAccount(String email, String otp);

	String regenerateOtp(String email);
	
	Optional<Designer> findDesignerById(Long id);

}
