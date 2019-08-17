package com.mercury.hibernate_demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mercury.hibernate_demo.bean.User;
import com.mercury.hibernate_demo.util.HibernateUtil;

public class Test2 {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		// how to read entire table?
		// select * from sample
		// HQL: hibernate query language
		String hql = "from User";
		Query query = session.createQuery(hql);
		query.setCacheable(true); // query result will be cached in SessionFactory.
		List<User> list = query.list();
		for (User u : list) {
			System.out.println(u.getName() + ": " + u.getAge());
		}
		
		// 会有两条从SQL取数据的语句，说明没有用session level的cache
		// 因为session query没有缓存in default，我们不能force它被cache到session
		// 只有用get(), load()才会有cache
		// 但我们可以用session factory 2nd level cache来实现query level cache
		List<User> list1 = query.list();
		for (User u : list1) {
			System.out.println(u.getName() + ": " + u.getAge());
		}
		
		// how to read by id? 重要
		// 1. load() : lazy! (class name, id)
		// a proxy object: 只是一个placeholder，并没有真的去数据库加载object，
		// 需要用的时候才去数据库去，为了performance (User_$$_javassist_0)
		// 如果不存在这个load对象，throw NotFoundException
//		User bob = (User) session.load(User.class, "bob"); // 在内存
//		System.out.println(bob.getClass().getName());
//		System.out.println(bob); // 这时候才会去找到bob
//		System.out.println(bob.getClass().getName()); // 加载后，还是代理对象
//		
//		// 2. get(): 直接去数据库访问，拿到user
//		// 如果不存在这个get对象，return null 空指针错误
//		User alex = (User) session.get(User.class, "alex");
//		System.out.println(alex.getClass().getName());
		
		// how to read data without primary key(id)?
//		Criteria ct = session.createCriteria(User.class);
//		List<User> usersLessThan25 = ct.add(Restrictions.lt("age", 25)).list(); // lt: less than
//		System.out.println(usersLessThan25);
//		// 用多个add实现chaining
//		User m25 = (User)ct.add(Restrictions.ilike("name", "%m%"))
//				.add(Restrictions.lt("age", 25))
//				.list().get(0);
//		System.out.println(m25);
//		User jim = (User)session.get(User.class, "jim");
//		System.out.println(jim); // 没有sql语句生成，因为上面的jim已经load到cache了，不需要去DB找
//		session.close(); // jim will be a detached instance
	}
	
}
