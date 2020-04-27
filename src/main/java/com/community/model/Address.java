package com.community.model;

public class Address {
	
	public Address() {}
	public Address(String addressLines,String state,String city,String zipCode,String country) {
		this.addressLines = addressLines;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}

	
	String addressLines;
	public String getAddressLines() {
		return addressLines;
	}
	public void setAddressLines(String addressLines) {
		this.addressLines = addressLines;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	String zipCode="";
	String state="";
	String city="";
	String country;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
