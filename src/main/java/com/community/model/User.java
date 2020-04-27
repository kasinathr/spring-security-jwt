package com.community.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class User {
	 @JsonCreator
public User(String firstName,String lastName,String phoneNumber,String password,String email,String[] role) {
		// TODO Auto-generated constructor stub
	this.firstName = firstName;
	this.lastName = lastName;
	//this.middleInitial = middleInitial;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.password = password;
	this.role = role;
	
	}
	 public User(String firstName) {
			// TODO Auto-generated constructor stub
		this.firstName = firstName;
		
		
		}
public User() {}
public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * public String getMiddleInitial() { return middleInitial; } public void
	 * setMiddleInitial(String middleInitial) { this.middleInitial = middleInitial;
	 * }
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getRole() {
		return role;
	}
	public void setRole(String[] role) {
		this.role = role;
	}
private String firstName;
private String lastName;
//private String middleInitial;
private String phoneNumber;
private String password;
private String email;
private String[] role;

}
