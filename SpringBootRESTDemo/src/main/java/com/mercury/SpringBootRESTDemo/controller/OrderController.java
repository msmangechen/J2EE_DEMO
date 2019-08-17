package com.mercury.SpringBootRESTDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRESTDemo.bean.Order;
import com.mercury.SpringBootRESTDemo.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/orders")
	public List<Order> getOrders() {
		return orderService.findAllOrders();
	}
	
}
