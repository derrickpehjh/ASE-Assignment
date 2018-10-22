package com.project.model;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "UserName is a required field")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Password is a required field")
	public void setPassword(String password) {
		this.password = password;
	}

}
