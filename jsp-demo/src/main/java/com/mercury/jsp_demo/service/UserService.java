package com.mercury.jsp_demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mercury.jsp_demo.bean.User;
import com.mercury.jsp_demo.dao.UserDao;
import com.mercury.jsp_demo.dao.impl.UserDaoImpl;

// service作用：放business logic
public class UserService {

	private UserDao userDao;
	
	public UserService() {
		userDao = new UserDaoImpl();
	}
	
	public List<User> getAllUsers() {
		return userDao.readUsers();
	}
	
	public List<User> getUsersAboveAge(int minAge) {
		return userDao.readUsers().stream() // 这就是business logic
				.filter(u -> u.getAge() >= minAge)
				.collect(Collectors.toList());
	}
	
}
