package com.mercury.SpringBootRESTDemo.bean;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "msi_user")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "MSI_USER_SEQ", allocationSize = 1)
	private long id;
	@Column
	private String username;
	@Column
	private String password;
	// 重要！！！
	// define mapping relationship
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="msi_user_msi_user_profile",
			joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}, // (jointable.user_id=user.id)
			inverseJoinColumns = {@JoinColumn(name="user_profile_id", referencedColumnName="id")} // define反方向，指多对多关系的另一端
			// 一对多的关系的话，只要JoinColumn，不用inverseJoinColumns
	) // define join table
	private Set<UserProfile> profiles; // 为了有可能去拿的用户profile
	// 因为有join，所以只会拿出符合id的这个user的所有权限(profiles)拿出来

	// 假想：locked，在isAccountNonLockedcheck locked的数字，如果超过10次就lock住
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String username, String password, Set<UserProfile> profiles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.profiles = profiles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserProfile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<UserProfile> profiles) {
		this.profiles = profiles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", profiles=" + profiles + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return profiles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
