package com.mercury.hibernate_demo;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.hibernate_demo.bean.User;
import com.mercury.hibernate_demo.util.HibernateUtil;

// 对数据库的 改删加 需要transaction
public class Test3 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User bob = (User)session.get(User.class, "bob");
//		bob.setAge(31); // 对persistent object进行了java的改变
		
		session.delete(bob);
		
		tx.commit();
	}

}
