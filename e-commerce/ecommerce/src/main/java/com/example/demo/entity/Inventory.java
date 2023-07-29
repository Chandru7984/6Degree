package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")

public class Inventory extends CreatedType{

	private Integer quantity;
	private Long storeid;
	private Long variantid;

	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getStoreid() {
		return storeid;
	}

	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}

	public Long getVariantid() {
		return variantid;
	}

	public void setVariantid(Long variantid) {
		this.variantid = variantid;
	}
}
