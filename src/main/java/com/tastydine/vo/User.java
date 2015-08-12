package com.tastydine.vo;

import java.sql.Date;

public class User {
	int id;
	String userName;
	String password;
	Date createdTime;
	Date modifiedTime;
	
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	

}
