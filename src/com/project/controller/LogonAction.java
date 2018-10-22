package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.project.model.User;
import com.project.service.UserService;

public class LogonAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private User userBean;
	public static final String LOGIN_SUCCESS = "success";
	public static final String LOGIN_FAILED = "error";

	public User getUserBean() {
		return userBean;
	}

	public void setUserBean(User user) {
		userBean = user;
	}

	@Override
	public String execute() throws Exception {
		ValueStack stack = ActionContext.getContext().getValueStack();
		String[] params = new String[] { userBean.getUserName(), userBean.getPassword() };
		UserService serv = new UserService();
		boolean isSuccess = serv.loginService(params);
		if (isSuccess)
			return LOGIN_SUCCESS;
		else {
			Map<String, Object> context = new HashMap<String, Object>();
			context.put("errorMsg", new String("Invalid user name or password. Try again."));
			stack.push(context);
			return LOGIN_FAILED;
		}
	}

}
