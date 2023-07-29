package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee")

public class Employee extends CreatedType{
	
	private String name;
	private String email;
	private String mobile;
	private String address;
	private BigDecimal salary;
	private Long storeid;
	private Long designationid;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

}
