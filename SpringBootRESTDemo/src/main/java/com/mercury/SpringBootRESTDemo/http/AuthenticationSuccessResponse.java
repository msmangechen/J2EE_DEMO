package com.mercury.SpringBootRESTDemo.http;

import com.mercury.SpringBootRESTDemo.bean.User;

public class AuthenticationSuccessResponse extends Response {

	private User user; // 成功了我想要user，失败了就不需要

	public AuthenticationSuccessResponse(boolean success, int code, String message, User user) {
		super(success, code, message);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
