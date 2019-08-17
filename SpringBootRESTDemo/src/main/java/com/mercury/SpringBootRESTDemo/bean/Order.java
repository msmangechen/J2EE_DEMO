package com.mercury.SpringBootRESTDemo.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "msi_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MSI_ORDER_SEQ_GEN")
	@SequenceGenerator(name = "MSI_ORDER_SEQ_GEN", sequenceName = "MSI_ORDER_SEQ", allocationSize = 1)
	private long id;
	@Column
	private Date purchase_date; // java8，还有ZonedDateTime
	// 一个user可以有多个order
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	User user;
	
	// fetch type: EAGER(load all data), LAZY(load when it use)
	// cascade: ALL, PERSIST, DELETE, REMOVE, MERGE (eg.order是否要影响purchase?)
	
	// order和purchase的关系已经在purchase配置
	// 为了避免重复的代码，我们可以用mappedBy
	@OneToMany(mappedBy = "order", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Purchase> purchases; // Purchase下面的变量order，来推导出他们的relationship

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(long id, Date purchase_date, User user, Set<Purchase> purchases) {
		super();
		this.id = id;
		this.purchase_date = purchase_date;
		this.user = user;
		this.purchases = purchases;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}

}
