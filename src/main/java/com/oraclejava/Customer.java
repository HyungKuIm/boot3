package com.oraclejava;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Customer { //Customer 테이블
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_code_seq")
	@SequenceGenerator(name = "customer_code_seq", sequenceName = "customer_seq", allocationSize = 1)
	private int customerCode;
	private String customerName;
	private String customerPass;
	private String role;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date customerBirth;
	private String customerJob;

	@Column(unique = true)
	private String customerMail;
	private String customerTel;
	private String customerPost;
	private String customerAdd;
	
	public String getCustomerPass() {
		return customerPass;
	}
	public void setCustomerPass(String customerPass) {
		this.customerPass = customerPass;
	}
	public int getCustomerCode() {
		return customerCode;
	}



	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getCustomerBirth() {
		return customerBirth;
	}
	public void setCustomerBirth(Date customerBirth) {
		this.customerBirth = customerBirth;
	}
	public String getCustomerJob() {
		return customerJob;
	}
	public void setCustomerJob(String customerJob) {
		this.customerJob = customerJob;
	}
	public String getCustomerMail() {
		return customerMail;
	}
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerPost() {
		return customerPost;
	}
	public void setCustomerPost(String customerPost) {
		this.customerPost = customerPost;
	}
	public String getCustomerAdd() {
		return customerAdd;
	}
	public void setCustomerAdd(String customerAdd) {
		this.customerAdd = customerAdd;
	}
	
	
	
	
}
