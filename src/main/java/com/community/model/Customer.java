package com.community.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Customer {
	//@Id
	//public String id;
	@JsonCreator
	public Customer(String firstName,String lastName,String phoneNumber,String password,String email,List<String> role, @JsonProperty("address") Address address,@JsonProperty("coach") Coach coach) {
		super();
		//this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.middleInitial = middleInitial;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.role = role;
		this.address = address;
		this.coach = coach;
		this.setCreateUpdate(new Date(System.currentTimeMillis()));
	}
	
	
    public Customer() {}    

	Address address;
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	Coach coach;
	boolean isActive = false;
	boolean isVerified = false;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
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
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> role) {
		this.role = role;
	}
private String firstName;
private String lastName;
//private String middleInitial;
private String phoneNumber;
private String password;
@Id
public String email;
private List<String> role;
private Date createUpdate;

public Date getCreateUpdate() {
	return createUpdate;
}


public void setCreateUpdate(Date createUpdate) {
	this.createUpdate = createUpdate;
}
}
