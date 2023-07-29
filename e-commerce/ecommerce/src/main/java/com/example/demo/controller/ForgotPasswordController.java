package com.example.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

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

import com.example.demo.dto.ForgotPasswordDto;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

import net.bytebuddy.utility.RandomString;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class ForgotPasswordController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private JavaMailSender javaMailSender;

	ResponseEntity<Object> resp = new ResponseEntity<Object>(HttpStatus.OK);

	@PostMapping("/forgot_password")
	public ResponseEntity<Object> forgotPassword(@RequestBody ForgotPasswordDto forgotDto) throws MessagingException {

		String email = forgotDto.getEmail();
		String token = RandomString.make(45);

		ResponseEntity<Object> passwordToken = customerService.updateResetPasswordToken(email, token);

		String resetPasswordLink = "http://localhost:4200/resetPassword?token="+token;

		sendLinkemail(forgotDto, resetPasswordLink,token);

		return passwordToken;
	}

	public void sendLinkemail(@RequestBody ForgotPasswordDto forgotDto, String resetPasswordLink ,String token)
			throws MessagingException {

		
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

		ResponseEntity<Object> response = new ResponseEntity<>("Invalid token", HttpStatus.BAD_REQUEST);

		String newpassword = forgotDto.getNewpassword();
		Customer customer = customerService.getToken(forgotDto.getToken());

		if ((customer == null) || (!(forgotDto.getToken()).equals(customer.getResetpasswordtoken()))) {
			return response;
		}else {
			customerService.updatePassword(customer, newpassword);
			return new ResponseEntity<>("Your password is Successfully changed", HttpStatus.OK);
		}
	}

}
