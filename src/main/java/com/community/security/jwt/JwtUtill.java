package com.community.security.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtill {
	private static String SECRET_KEY = "Secret";
	public static String extractUserName(String token) {
		return extractClaim(token,Claims::getSubject);
		
	}

	public static Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	
	public static <T> T extractClaim (String token, Function<Claims,T> claimResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}
	private static Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	private static Boolean isTokenExpired(String token) {
		Boolean isExp = extractExpiration(token).before(new Date());
		
		return isExp;
	}
	public static String generateToken(UserDetails user) {
		Map <String, Object> claims = new HashMap<>();
		return createToken(claims,user.getUsername());
		
	}

	private static String createToken(Map<String, Object> claims, String username) {
		// TODO Auto-generated method stub
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	public static Boolean validateToken(String token, UserDetails userDetails) {
		final String userName = extractUserName(token);
		return (userName.equals(userDetails.getUsername()) && isTokenExpired(token));
	}

	
	
}
