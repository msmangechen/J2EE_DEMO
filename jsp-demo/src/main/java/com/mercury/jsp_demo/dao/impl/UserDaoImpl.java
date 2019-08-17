package com.mercury.jsp_demo.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mercury.jsp_demo.bean.User;
import com.mercury.jsp_demo.dao.UserDao;
import com.mercury.jsp_demo.util.JdbcUtil;

// DAO: 把数据库对应的对象同一放到这里，对数据库进行更删改查
public class UserDaoImpl implements UserDao {

	@Override
	public List<User> readUsers() {
		List<User> users = new ArrayList<>();
		try (
			Connection conn = JdbcUtil.getConnection();
		) {
			String sql = "select * from sample";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				users.add(new User(rs.getString("name"), rs.getInt("age")));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

}
