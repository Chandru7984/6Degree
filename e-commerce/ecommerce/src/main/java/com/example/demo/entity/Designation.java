package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="designation")

public class Designation extends CreatedType{
	
	private String name;
	
	public Designation() {
		// TODO Auto-generated constructor stub
	}

}
