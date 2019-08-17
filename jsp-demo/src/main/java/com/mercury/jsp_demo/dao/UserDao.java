package com.mercury.jsp_demo.dao;

import java.util.List;

import com.mercury.jsp_demo.bean.User;

public interface UserDao {

	List<User> readUsers();
	void createUser(User user);
	void deleteUser(String name);
	void updateUser(User user);
	
}
