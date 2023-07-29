package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="storebrand")

public class StoreBrand extends CreatedType{
	
	private Long brandid;
	private Long storeid;
	
	public StoreBrand() {
		// TODO Auto-generated constructor stub
	}

	public Long getBrandid() {
		return brandid;
	}

	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}

	public Long getStoreid() {
		return storeid;
	}

	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}
	
	

}
