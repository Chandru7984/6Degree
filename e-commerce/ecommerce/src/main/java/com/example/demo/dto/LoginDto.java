package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginDto {

	private String email;
	
	private String password;
	
	private Integer active;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}
