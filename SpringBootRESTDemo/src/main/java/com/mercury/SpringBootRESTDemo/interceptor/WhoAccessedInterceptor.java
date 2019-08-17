package com.mercury.SpringBootRESTDemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class WhoAccessedInterceptor extends HandlerInterceptorAdapter {

	
	// preHandle postHandle可以实现spring自己的@PreAuthorize @PostAuthorize
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(request.getRemoteAddr() + "accessed your API.");
	}

}
