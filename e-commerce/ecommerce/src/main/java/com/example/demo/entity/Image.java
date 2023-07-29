package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "image")

public class Image extends CreatedType{

	private String path;
	private Integer heirarchy;
	private Long variantid;

	public Image() {
		// TODO Auto-generated constructor stub
	}

}
