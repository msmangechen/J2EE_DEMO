package com.mercury.SpringBootRESTDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// 凡是有自己数据的表都必须加上mapping（也就是说不包括ID）
@Entity
@Table(name = "msi_order_product")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MSI_ORDER_PRODUCT_SEQ_GEN")
	@SequenceGenerator(name = "MSI_ORDER_PRODUCT_SEQ_GEN", sequenceName = "MSI_ORDER_PRODUCT_SEQ", allocationSize = 1)
	private long id;
	@Column
	private int qty;
	// 定义的relationship是属于current table，我们定义的是这个table到别的table的关系！！
	// msi_order_product-> order
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	// if we don't have it we will have infinity loop, convert to JSON data.
	// During convert, ignore order(because already in purchase) to avoid infinity loop
	@JsonIgnore
	private Order order;
	// msi_order_product-> product
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase(long id, int qty, Order order, Product product) {
		super();
		this.id = id;
		this.qty = qty;
		this.order = order;
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
