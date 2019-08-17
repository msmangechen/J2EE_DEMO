package com.mercury.SpringBootRESTDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.SpringBootRESTDemo.bean.Order;
import com.mercury.SpringBootRESTDemo.dao.OrderDao;

// transaction isolation level: when we have multiple transactions happens in the same table, how should we let it execute 
// transaction propagation level:

@Service
// 放在transaction执行，如果其中一个步骤失败，抛出异常之后，事务会自动回滚，数据不会插入到数据库。
@Transactional // (isolation=Isolation.READ_UNCOMMITTED)
public class OrderService {
	
	@Autowired
	OrderDao orderDao;

	public List<Order> findAllOrders() {
		return orderDao.findAll();
	}
	
	public void addOrder(Order order) {
		// 1. loadOrder 
		// 2. check stock
		// 3. add order
		// 4. update record
	}
	
	public void updateOrder(Order order) {
		// loadOrder
	}
	
	public Order loadOrder(long id) {
		return orderDao.getOne(id); // findById will return Optional
	}
	
}
