package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Designer;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin
@Validated
//@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService service;

//	@Autowired
//	private JwtService jwtService;

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public ResponseEntity<Object> signUp(@Valid @RequestBody UserDto userDto) {
		if (userDto.getEmail() == null) {
			return new ResponseEntity<>("Email cannot be null", HttpStatus.BAD_REQUEST);
		}
		if (userRepository.existsByEmail(userDto.getEmail())) {
			return new ResponseEntity<>("Email already exist", HttpStatus.BAD_REQUEST);
		}

		if (userDto.getPassword() == null) {
			return new ResponseEntity<>("Password cannot be null", HttpStatus.BAD_REQUEST);
		}

		if (!(userDto.getPassword().equals(userDto.getConfirmpassword()))) {
			return new ResponseEntity<>("Password is not matched", HttpStatus.BAD_REQUEST);
		}
		if (userRepository.existsByPassword(userDto.getPassword())) {
			return new ResponseEntity<>("Password already exist", HttpStatus.BAD_REQUEST);
		}
		if (userDto.getMobile() == null) {
			return new ResponseEntity<>("Mobile number cannot be null", HttpStatus.BAD_REQUEST);
		}
		if (userRepository.existsByMobile(userDto.getMobile())) {
			return new ResponseEntity<>("Mobile number already exist", HttpStatus.BAD_REQUEST);
		}
		MultiValueMap<String, String> status = new HttpHeaders();
		status.add("status", "200");
		Designer designer = service.saveUser(userDto);
		return new ResponseEntity<>(designer, status, HttpStatus.OK);
	}

	@PostMapping("/signin")
	public ResponseEntity<Object> signIn(@Valid @RequestBody LoginDto loginDto) {

		Optional<Designer> findByEmail = userRepository.findByEmail(loginDto.getEmail());
		if ((findByEmail.isPresent())) {
			return service.findByEmailAndPassword(loginDto);
		}
		return new ResponseEntity<>("Invalid Email Address", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/verify-account")
	public ResponseEntity<Object> verifyAccount(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "otp", required = true) String otp) {
		return new ResponseEntity<Object>(service.verifyAccount(email, otp), HttpStatus.OK);
	}

	@PutMapping("/regenerate-otp")
	public ResponseEntity<String> regenerateOtp(@RequestParam String email) {
		return new ResponseEntity<>(service.regenerateOtp(email), HttpStatus.OK);
	}

	@GetMapping("designer/{id}")
	public ResponseEntity<Optional<Designer>> getUserDetails(@PathVariable Long id) {
		Optional<Designer> user = userRepository.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} 
		return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
	}

//	@PostMapping("/authenticate")
//	public String generateToken(@RequestBody Authrequest authRequest) {
//		Authentication authenticate = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
//		if (authenticate.isAuthenticated()) {
//			return jwtService.generateToken(authRequest.getEmail());
//		} else {
//			throw new UsernameNotFoundException("Invalid User");
//		}
//	}

//	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//            loginDto.getUsernameOrEmail(), loginDto.getPassword()));
//
//    SecurityContextHolder.getContext().setAuthentication(authentication);
//    return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);

}
