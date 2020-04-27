package com.community.security.jwt.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.community.model.Customer;



@Service
public class APUserDetailsService implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepo;
	
	final Log logger = LogFactory.getLog(getClass());

	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		String dbUserName;
		String dbPassword;
		try {
		
		Customer cust = customerRepo.findByEmail(userName);
		dbUserName = cust.getEmail();
		dbPassword = cust.getPassword();
		if(null!=dbUserName && null!=dbPassword)
				return User.builder().roles("USER").password(dbPassword).username(dbUserName).build();
		else throw new UsernameNotFoundException("No Matching User Name or Password ");
		}catch(UsernameNotFoundException exp){
			logger.info("User Name not found"+userName);
			exp.printStackTrace();
			throw exp;
		}catch(Exception exp){
			logger.info("User not found"+userName);
			exp.printStackTrace();
			throw new UsernameNotFoundException("User Not found");
			
		}
		//return User.builder().roles("ADMIN","USER","COACH").password("foo").username("foo").build();
	
		//return new User("foo","foo",new ArrayList<>());
	}

}
