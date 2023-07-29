package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="subtype")

public class SubType extends CreatedType{
	
	private String name;
	private Long producttypeid;
	
	public SubType() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProducttypeid() {
		return producttypeid;
	}

	public void setProducttypeid(Long producttypeid) {
		this.producttypeid = producttypeid;
	}
	
	

}
