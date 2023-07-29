package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product")

public class Product extends CreatedType{

	private Long brandid;
	private String name;
	private Long categoryid;
	private Long subtypeid;
	private Long materialid;
	private Long washcareid;
	private String productnumber;
	private String description;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Long getBrandid() {
		return brandid;
	}

	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public Long getSubtypeid() {
		return subtypeid;
	}

	public void setSubtypeid(Long subtypeid) {
		this.subtypeid = subtypeid;
	}

	public Long getMaterialid() {
		return materialid;
	}

	public void setMaterialid(Long materialid) {
		this.materialid = materialid;
	}

	public Long getWashcareid() {
		return washcareid;
	}

	public void setWashcareid(Long washcareid) {
		this.washcareid = washcareid;
	}

	public String getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
