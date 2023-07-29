package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class Cart extends CreatedType{

	private Integer quantity;
	private Long customerid;
	private Long variantid;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
