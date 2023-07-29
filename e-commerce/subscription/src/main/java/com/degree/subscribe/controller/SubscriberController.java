package com.degree.subscribe.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.degree.subscribe.dto.SubscriberDto;
import com.degree.subscribe.repository.SubscriberRepository;
import com.degree.subscribe.service.SubscriberService;

@RestController
@CrossOrigin
public class SubscriberController {

	@Autowired
	private SubscriberRepository repository;

	@Autowired
	private SubscriberService service;

	@PostMapping("/subscribe")
	public ResponseEntity<Object> subscribe(@RequestBody SubscriberDto subscriberDto) throws Exception {

		if (Objects.isNull(subscriberDto.getEmail())) {
			return new ResponseEntity<>("Email cannot be null", HttpStatus.BAD_REQUEST);
		}

		if (repository.existsByEmail(subscriberDto.getEmail())) {
			return new ResponseEntity<>("Email already exist", HttpStatus.BAD_REQUEST);
		}
		
		service.saveSubscriber(subscriberDto);
		
		Map<String, String> success = new HashMap<>();
		success.put("Sucess","Subscription Successful!");

		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}
