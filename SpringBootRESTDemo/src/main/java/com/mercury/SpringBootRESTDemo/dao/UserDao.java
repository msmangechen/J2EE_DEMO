package com.mercury.SpringBootRESTDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRESTDemo.bean.User;

public interface UserDao extends JpaRepository<User, Long> {
	
	User findByUsername(String username); // query method，按照语法写就能生成SQL语句
	
}
