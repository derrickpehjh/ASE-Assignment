package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.project.model.User;
import com.project.repository.UserRepository;


/*
 *Controller Action Class which communicates with the business layer
 * 
 */
public class LogonAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public static final String LOGIN_SUCCESS = "success";
	public static final String LOGIN_FAILED = "error";

	private User userBean;

	public User getUserBean() {
		return userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	/*
     * (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     * Overrides default execute method to retrieve username and password 
     * and sends to the database. Database retrieves the query and returns boolean
     */
	@Override
	public String execute() throws Exception {
		ValueStack stack = ActionContext.getContext().getValueStack();
		String[] params = new String[] {userBean.getUserName(), userBean.getPassword()};
		UserRepository repo = new UserRepository();
		boolean isSuccess = repo.containsResult(params);
		if (isSuccess)
			return LOGIN_SUCCESS;
		else {
			Map<String, Object> context = new HashMap<String, Object>();
			context.put("errorMsg", new String("Invalid user name or password. Try again."));
			stack.push(context);
			return LOGIN_FAILED;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 * Overrides validate method to do client side validation for username and
	 * password fields
	 */
    @Override
    public void validate() {
         if (userBean.getUserName() == null || userBean.getUserName().trim().equals(""))
          {
             addFieldError("userBean.userName","Please enter a user name to login with.");
          }
         if (userBean.getPassword() == null || userBean.getPassword().trim().equals(""))
          {
             addFieldError("userBean.password","Please enter a password.");
          }
    }

}
