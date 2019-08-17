package com.mercury.SpringBootRESTDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.SpringBootRESTDemo.bean.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	// 在SQL中找到了数据再给Java，因为只有findById，如果要findAll再找的话time太多
	// 识别出我们需要的语句
	List<Product> findByName(String name);
	
	// JPQL: Java Persistent Query Language, 自己定义query，操纵的是class
	@Query("select p from Product p where p.stock >= :stock")
	List<Product> findProductsWithStock(@Param("stock") int stock);
	
}
