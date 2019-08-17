package com.mercury.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

// 用@Component，Spring在启动的时候创建User，普通的bean class
@Component
//annotation指定scope(default:singleton)，每次都会拿到singleton，还有SCOPE_PROTOTYPE
//@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(value=WebApplicationContext.SCOPE_REQUEST) // 每个请求都是一个新的object
public class User {
	
	@Value(value="bob")
	private String name;
	@Value(value="21")
	private int age;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
