package com.degree.subscribe.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SubscriberDto {
	
	@NotBlank
	private String fullname;

	@NotBlank
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;

//	@NotBlank
//	private String mobile;

	@NotBlank
	private String department;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
