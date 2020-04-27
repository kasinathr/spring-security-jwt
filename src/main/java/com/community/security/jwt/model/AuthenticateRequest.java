package com.community.security.jwt.model;

public class AuthenticateRequest {
	
	public AuthenticateRequest() {
		// TODO Auto-generated constructor stub
	}
	public AuthenticateRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	private String username;
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
	private String password;

}
