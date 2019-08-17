package com.mercury.spring_ioc_demo.bean;

public class Wrapper {

	private User user;
	private Person person;

	public Wrapper() {
		super();
	}

	public Wrapper(User user, Person person) {
		super();
		this.user = user;
		this.person = person;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Wrapper [user=" + user + ", person=" + person + "]";
	}

}
