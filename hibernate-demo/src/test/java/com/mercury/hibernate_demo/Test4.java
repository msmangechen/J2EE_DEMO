package com.mercury.hibernate_demo;

import org.hibernate.Session;

import com.mercury.hibernate_demo.bean.User;
import com.mercury.hibernate_demo.util.HibernateUtil;

public class Test4 {
	
	public static void main(String[] args) {
		// 不能getSession(Singleton), openSession(开个新的session)
		Session s1 = HibernateUtil.FACTORY.openSession();
		User u1 = (User)s1.get(User.class, "alex");
		System.out.println(u1);
		s1.close();
		
		Session s2 = HibernateUtil.FACTORY.openSession();
		User u2 = (User)s2.get(User.class, "alex");
		System.out.println(u2);
		s2.close();
		
	}
	
}
