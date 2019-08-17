package com.mercury.hibernate_demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	// 生成session factory
	public static final SessionFactory FACTORY;
	// 好处：可以写try catch
	static {
		try {
			FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	private static final ThreadLocal<Session> SESSION = new ThreadLocal<Session>() {

		@Override
		protected Session initialValue() { // 通过初始化，保证每个thread只会有一个session
			return FACTORY.openSession();
		}
		
	};
	
	public static Session getSession() {
		return SESSION.get();
	}
	
}
