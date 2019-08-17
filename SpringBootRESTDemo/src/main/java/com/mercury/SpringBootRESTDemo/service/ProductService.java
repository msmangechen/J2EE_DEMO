package com.mercury.SpringBootRESTDemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRESTDemo.bean.Product;
import com.mercury.SpringBootRESTDemo.dao.ProductDao;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public List<Product> getProducts() {
		return productDao.findAll();
	}

	public List<Product> getProductsUsingName(String name) {
		return productDao.findByName(name);
	}
	
	public List<Product> getProductsHavingStock(int stock) {
		return productDao.findProductsWithStock(stock);
	}
	
}
