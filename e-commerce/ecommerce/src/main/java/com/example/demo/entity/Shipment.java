package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="shipment")

public class Shipment extends CreatedType{
	
	private Long orderdetailsid;
	private Long statusid;
	private String logisticspartner;
	
	public Shipment() {
		// TODO Auto-generated constructor stub
	}

	public Long getOrderdetailsid() {
		return orderdetailsid;
	}

	public void setOrderdetailsid(Long orderdetailsid) {
		this.orderdetailsid = orderdetailsid;
	}

	public Long getStatusid() {
		return statusid;
	}

	public void setStatusid(Long statusid) {
		this.statusid = statusid;
	}

	public String getLogisticspartner() {
		return logisticspartner;
	}

	public void setLogisticspartner(String logisticspartner) {
		this.logisticspartner = logisticspartner;
	}

}
