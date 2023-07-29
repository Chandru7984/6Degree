package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")

public class OrderDetails extends CreatedType{
	
	private Long variantid;
	private String quantity;
	private Long ordersid;
	private BigDecimal totalprice;
	private Date expecteddelivery;
	
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public Long getVariantid() {
		return variantid;
	}

	public void setVariantid(Long variantid) {
		this.variantid = variantid;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Long getOrdersid() {
		return ordersid;
	}

	public void setOrdersid(Long ordersid) {
		this.ordersid = ordersid;
	}

	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public Date getExpecteddelivery() {
		return expecteddelivery;
	}

	public void setExpecteddelivery(Date expecteddelivery) {
		this.expecteddelivery = expecteddelivery;
	}

	
}
