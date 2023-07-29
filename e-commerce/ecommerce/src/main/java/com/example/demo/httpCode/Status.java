package com.example.demo.httpCode;

import org.springframework.stereotype.Component;

@Component
public class Status {

	public static final String SUCCESS = "User Created Successfully";
	public static final String DUPLICATE_EMAIL = "Email is alredy exist";
	public static final String REQUIRED_EMAIL = "Email is required";
	public static final String REQUIRED_MOBILE = "Mobile number is required";
	public static final String DUPLICATE_MOBILE = "Mobile number is already exist";
	public static final String DUPLICATE_PASSWORD = "Password is already exist";
	public static final String REQUIRED_PASSWORD = "Password is required";
	public static final String SIGNIN_SUCCESS = "SignIn Successfully";
	public static final String USER_EXIST = "User doesn't exist";
	public static final String INCORRECT_PASSWORD = "Incorrect Password";
	public static final String PASSWORD_NOT_MATCHED = "Password is not matched";
	
}
