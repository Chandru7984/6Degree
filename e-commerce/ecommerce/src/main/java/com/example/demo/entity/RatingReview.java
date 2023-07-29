package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ratingsreviews")

public class RatingReview extends CreatedType{
	
	private BigDecimal rating;
	private String comment;
	private Long orderdetailsid;
	private Long customerid;
	
	public RatingReview() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getOrderdetailsid() {
		return orderdetailsid;
	}

	public void setOrderdetailsid(Long orderdetailsid) {
		this.orderdetailsid = orderdetailsid;
	}

	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}
	
	

}
