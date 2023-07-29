package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category extends CreatedType{

	private String name;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
