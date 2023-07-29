package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "color")
public class Color extends CreatedType{

	private String name;
	private String hexacode;

	public Color() {
		// TODO Auto-generated constructor stub
	}
}
