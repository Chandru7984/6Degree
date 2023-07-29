package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand extends CreatedType {

	private String name;
	private String logo;
	private String description;
	private Long designerid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDesignerid() {
		return designerid;
	}

	public void setDesignerid(Long designerid) {
		this.designerid = designerid;
	}

}
