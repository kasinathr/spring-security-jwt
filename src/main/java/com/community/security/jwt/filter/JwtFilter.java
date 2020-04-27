package com.community.security.jwt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.community.security.jwt.JwtUtill;
import com.community.security.jwt.services.APUserDetailsService;
@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private APUserDetailsService userDetailsService;

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// HttpServletResponse response = (HttpServletResponse) res;
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Content-Length, X-Requested-With");
		
		// TODO Auto-generated method stub
		logger.info("This methid is called");
		final String autherizationHeader = request.getHeader("Authorization");
		logger.info("The Autherization header is"+autherizationHeader);
		logger.info("The XYZ header is"+request.getHeader("ABC"));

		String userName = null;
		String jwt = null;
		if(autherizationHeader!=null && autherizationHeader.startsWith("Bearer")) {
			logger.info("Autherization call");
			jwt = autherizationHeader.substring(7);
			userName = JwtUtill.extractUserName(jwt);
			logger.info("The user Name is "+userName);
			logger.info("The JWT is "+jwt);
		
		}
		logger.info("The user name is"+userName);
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
			if(!JwtUtill.validateToken(jwt, userDetails)) {
				logger.info("User authenticated");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}
		}
		filterChain.doFilter(request, response);
		
		
	}

}
