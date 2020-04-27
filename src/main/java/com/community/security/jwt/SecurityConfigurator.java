package com.community.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;

import com.community.error.CustomAuthenticationFailureHandler;
import com.community.security.jwt.filter.JwtFilter;
import com.community.security.jwt.services.APUserDetailsService;

@EnableWebSecurity
public class SecurityConfigurator extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private APUserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
//	@Bean
//	public PasswordEncoder passwordEncoder1() {
//		return new BCryptPasswordEncoder();
//	}
	@Bean
	public AuthenticationFailureHandler customAuthenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}
	
   
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
		
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public AuthenticationManager authenticationManegerBean() throws Exception{
		return super.authenticationManager();
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests().
		requestMatchers(CorsUtils::isCorsRequest).permitAll().
		antMatchers("/authentication","/create").permitAll().
		anyRequest().authenticated().and().
		sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	}
	//Not to do the password Hashing while the password is coming.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
}
