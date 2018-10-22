package com.project.service;

import com.project.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;

	public UserService() {
		// TODO Auto-generated constructor stub
		userRepository = new UserRepository();
	}

	public boolean loginService(String[] params) {
		boolean status = false;
		if (userRepository != null) {
			try {
				status = userRepository.containsResult(params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		}
		return status;

	}
}
