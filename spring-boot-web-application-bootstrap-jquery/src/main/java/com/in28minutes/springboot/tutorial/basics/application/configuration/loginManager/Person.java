package com.in28minutes.springboot.tutorial.basics.application.configuration.loginManager;


//@Entity
public class Person {
//	@Id
	String userID;
	String Name;
	String Password;
	
	public Person() {
		super();
	}
	
	public Person(String userID, String name, String password) {
		super();
		this.userID = userID;
		Name = name;
		Password = password;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
