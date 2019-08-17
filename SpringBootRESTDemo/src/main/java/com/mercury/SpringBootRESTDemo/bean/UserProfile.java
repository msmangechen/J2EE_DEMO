package com.mercury.SpringBootRESTDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "msi_user_profile")
public class UserProfile implements GrantedAuthority { // 为了让Spring security识别权限类
	
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	@Column
	private String type; // Spring security无法识别权限类，让security用getAuthority获得

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile(long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", type=" + type + "]";
	}

	@Override
	public String getAuthority() { // return用户的权限的值
		return type;
	}

}
