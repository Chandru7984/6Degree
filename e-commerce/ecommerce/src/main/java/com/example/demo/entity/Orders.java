package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="orders")

public class Orders extends CreatedType{
	
	private BigDecimal totalprice;
	private String ordernumber;
	private Long customeraddressid;
	private Long paymentdetailsid;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public Long getCustomeraddressid() {
		return customeraddressid;
	}

	public void setCustomeraddressid(Long customeraddressid) {
		this.customeraddressid = customeraddressid;
	}

	public Long getPaymentdetailsid() {
		return paymentdetailsid;
	}

	public void setPaymentdetailsid(Long paymentdetailsid) {
		this.paymentdetailsid = paymentdetailsid;
	}
	
	

}
