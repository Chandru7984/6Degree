package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends CreatedType {

	private String fullname;

	private String email;

	private String password;

	private String mobile;
	
	private String resetpasswordtoken;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "designerid")
	private Long designerid;
	
//	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CustomerAddress> addresses = new ArrayList<>();

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getDesignerid() {
		return designerid;
	}

	public void setDesignerid(Long designerid) {
		this.designerid = designerid;
	}

	public String getResetpasswordtoken() {
		return resetpasswordtoken;
	}

	public void setResetpasswordtoken(String resetpasswordtoken) {
		this.resetpasswordtoken = resetpasswordtoken;
	}
}
