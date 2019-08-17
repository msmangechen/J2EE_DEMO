package com.mercury.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.bean.User;

// @Component
// 衍生，都包含了@Component，@Controller, @Service, @Repository（放在DAO），更有语义化（让Spring更好的理解他们）

@Controller
public class HelloController {

	// autowire by type
	// @Resource will autowire by name
	@Autowired
	User user;
	
	// handle get发给/hello的请求，每次收到get请求，这个function都会被调用一次
	// GET /hi -> HelloController -> /views/hello.jsp 通过ViewResolver找到
	@RequestMapping(method=RequestMethod.GET, value="/hi") // http://localhost:8081/spring-mvc-demo/hi
	public String hi() {
		return "hello"; // "hello"是view name, /views/hello.jsp
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/hello")
	public ModelAndView hello(HttpSession session) { // 重要！session!
		ModelAndView mav= new ModelAndView(); // 重要！model is data, view is view name
		mav.setViewName("hello");
		user.setAge(user.getAge() + 1);
		// (data is the name of variable we will use in JSP to get the user, 上面autowire的user)
		mav.addObject("data", user);
		session.setAttribute("count", 666); // session里有个数据count:666
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users")
	// 重要！！！！！！！
	// 让Spring convert return as JSON format(array of object) and return directly(skip viewResolver)，可以用在JS
	// 这就是如何用MVC搭web service
	@ResponseBody
	public List<User> getUsers() {
		List<User> list = new ArrayList<>();
		list.add(user);
		return list;
	}
	
}
