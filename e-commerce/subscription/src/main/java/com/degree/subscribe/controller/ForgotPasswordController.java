package com.degree.subscribe.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.degree.subscribe.dto.ForgotPasswordDto;
import com.degree.subscribe.entity.Customer;
import com.degree.subscribe.service.CustomerService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
@CrossOrigin
@RequestMapping("/Subscriber")
public class ForgotPasswordController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private JavaMailSender javaMailSender;

	ResponseEntity<Object> resp = new ResponseEntity<Object>(HttpStatus.OK);

	@PostMapping("/forgot_password")
	public ResponseEntity<Object> forgotPassword(@RequestBody ForgotPasswordDto forgotDto) throws MessagingException {

		String email = forgotDto.getEmail();
		String token = RandomStringUtils.randomAlphanumeric(50);

		ResponseEntity<Object> passwordToken = customerService.updateResetPasswordToken(email, token);

		String resetPasswordLink = "http://localhost:4200/resetPassword?token="+token;

		sendLinkemail(forgotDto, resetPasswordLink,token);

		return passwordToken;
	}

	public void sendLinkemail(@RequestBody ForgotPasswordDto forgotDto, String resetPasswordLink ,String token) throws MessagingException {

		
		String content = "<p>Hello,</p>" + "<p>Click the below link to change the password</p>"
				+ "<span><b>"+token+" </b></span>" + "<a href=\""
				+ resetPasswordLink + "\">Change my password</a>";

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setFrom("Fashion" + "Store");
		mimeMessageHelper.setTo(forgotDto.getEmail());
		mimeMessageHelper.setSubject("Change Password");
		mimeMessageHelper.setText(content, true);

		javaMailSender.send(mimeMessage);
	}

	@PostMapping("/resetPassword")
	public ResponseEntity<Object> resetPassword(@RequestBody ForgotPasswordDto forgotDto) {

//		ResponseEntity<Object> response = new ResponseEntity<>("Invalid token", HttpStatus.BAD_REQUEST);

		String newpassword = forgotDto.getNewpassword();
		Customer customer = customerService.getToken(forgotDto.getToken());

		if ((customer == null) || (!(forgotDto.getToken()).equals(customer.getResetpasswordtoken()))) {
			
			Map<String, String> error = new HashMap<>();
			error.put("error", "Invalid token");
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			
		}else {
			customerService.updatePassword(customer, newpassword);
			
			Map<String, String> success = new HashMap<>();
			success.put("Success", "Your password is Successfully changed!");
			
			return new ResponseEntity<>(success, HttpStatus.OK);
		}
	}

}
