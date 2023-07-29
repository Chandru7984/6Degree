package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "variant")

public class Variant extends CreatedType{

	private Long productid;
	private Long sizeid;
	private Long colorid;
	private Long weighttypeid;
	private BigDecimal weight;
	private BigDecimal mrp;
	private BigDecimal sellingprice;
	private String quantity;

	public Variant() {
		// TODO Auto-generated constructor stub
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Long getSizeid() {
		return sizeid;
	}

	public void setSizeid(Long sizeid) {
		this.sizeid = sizeid;
	}

	public Long getColorid() {
		return colorid;
	}

	public void setColorid(Long colorid) {
		this.colorid = colorid;
	}

	public Long getWeighttypeid() {
		return weighttypeid;
	}

	public void setWeighttypeid(Long weighttypeid) {
		this.weighttypeid = weighttypeid;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getMrp() {
		return mrp;
	}

	public void setMrp(BigDecimal mrp) {
		this.mrp = mrp;
	}

	public BigDecimal getSellingprice() {
		return sellingprice;
	}

	public void setSellingprice(BigDecimal sellingprice) {
		this.sellingprice = sellingprice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
