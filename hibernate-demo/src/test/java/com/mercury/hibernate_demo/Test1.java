package com.mercury.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.hibernate_demo.bean.User;
import com.mercury.hibernate_demo.util.HibernateUtil;

public class Test1 {
	
	public static void main(String[] args) {
		User user = new User("mary", 26); // transient状态
		Session session = HibernateUtil.getSession();
		// 手动创造transaction，让SQL语句错误时rollback
		Transaction transaction = session.beginTransaction();
		session.save(user); // persistent state
//		session.flush(); // 告诉Hibernate搞好了，会生成SQL语句，但是数据库不会真的执行
		transaction.commit(); // 自动执行flush() session，会在数据库执行，保证数据的完整性（指令要么成功/失败）
	}
	
}
