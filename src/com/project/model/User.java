package com.project.model;

import com.project.service.UserService;

public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}

	private String userName;
	private String password;
	
	public boolean getCred() {
		String[] params = new String[] { this.getUserName(), this.getPassword() };
		UserService serv = new UserService();
		return  serv.loginService(params);
		
	}
	

	public String getUserName() {
		return userName;
	}

	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
