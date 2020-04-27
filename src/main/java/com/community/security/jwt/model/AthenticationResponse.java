package com.community.security.jwt.model;

public class AthenticationResponse {
	
private final String jwt;

public AthenticationResponse(String jwt) {
	this.jwt = jwt;
	// TODO Auto-generated constructor stub
}
	public String getJwt() {
		return jwt;
	}

}
