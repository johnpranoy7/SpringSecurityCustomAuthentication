package com.john.graphite.bean;

public class MyUser {
	private String userId;
	private String email;
	private String phone;

	public MyUser(String userId, String email, String phone) {
		super();
		this.userId = userId;
		this.email = email;
		this.phone = phone;
	}

	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MyUser [userId=" + userId + ", email=" + email + ", phone=" + phone + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
