package com.expense.model;

public class Tracker {
	
	private String email, title, payment_mode, payment_type;
	private Integer amount;
	
	public Tracker() {
		super();
	}
	public Tracker(String email, String title, String payment_mode, String payment_type, int amount) {
		super();
		this.email = email;
		this.title = title;
		this.payment_mode = payment_mode;
		this.payment_type = payment_type;
		this.amount = amount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	



}
