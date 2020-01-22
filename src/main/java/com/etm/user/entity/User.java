package com.etm.user.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User implements Serializable {

	@Id
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_password")
	private String userPassword;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	
	
}

