package com.mercury.spring_ioc_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mercury.spring_ioc_demo.bean.User;
import com.mercury.spring_ioc_demo.bean.Wrapper;

public class TestIoC {

	public static void main(String[] args) {
		// Spring Container: BeanFactory, ApplicationContext(inherited from BeanFactory, heavier)
		ApplicationContext actx = new FileSystemXmlApplicationContext("resource/iocconfig.xml");
		User bob = (User) actx.getBean("user"); // 对象创建给Spring做，控制反转
		System.out.println(bob);
		User bob1 = (User) actx.getBean("user");
		System.out.println(bob == bob1); // true: Singleton 拿到的是同一个对象, 改为prototype后false: 每次拿数据都会return a new Object
		// spring bean scope: singleton(default), prototype, request, session
		// prototype: create a new object every time of request
		// request: 每次request，在这次request中的object都是同一个，不同的request是不同的object（eg.3个人早中晚去，获得9个包子）
		// session: 跟用户绑定，同一个用户同一个object，无论request几次
		
		Wrapper wrapper = (Wrapper) actx.getBean("wrapper1");
		System.out.println(wrapper);
	}

}
