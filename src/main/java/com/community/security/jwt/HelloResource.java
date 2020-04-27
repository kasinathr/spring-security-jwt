package com.community.security.jwt;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.community.error.AppException;
import com.community.model.CommunityClass;
import com.community.model.Customer;
import com.community.security.jwt.model.AthenticationResponse;
import com.community.security.jwt.model.AuthenticateRequest;
import com.community.security.jwt.services.APUserDetailsService;
import com.community.security.jwt.services.CommunityClassService;
import com.community.security.jwt.services.CustomerService;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
public class HelloResource {
@Autowired
private AuthenticationManager authManager;
@Autowired
private APUserDetailsService userDetailsService;
@Autowired
private CustomerService customerService;
@Autowired
private CommunityClassService commService;
//@Autowired
//private BCryptPasswordEncoder passwordEncoder;

@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping(value="/authentication",method = RequestMethod.POST,consumes = "application/json") 
public ResponseEntity<?> createAuthenticationToken(@RequestBody  AuthenticateRequest authenticationRequest)throws AppException {
	try {
	
	authManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
			authenticationRequest.getPassword()));
	}catch(BadCredentialsException exp){
		exp.printStackTrace();
		throw new BadCredentialsException("Bad User Credentials", exp);
	}catch(Exception exp) {
		exp.printStackTrace();
		throw new AppException("User Not Found", exp);
	}
	final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	final String jwt = JwtUtill.generateToken(userDetails);
	return ResponseEntity.ok(new AthenticationResponse(jwt));
}
	/*
	 * @CrossOrigin(origins="*",allowedHeaders="*")
	 * 
	 * @PostMapping(path = "/authenticate", consumes = "application/json", produces
	 * = "application/json") public Customer authenticate(@RequestBody Customer
	 * customer) { return new Customer(customer.getFirstName(),
	 * customer.getLastName(), customer.getmI(),
	 * customer.getAddressLines(),customer.getZipCode(),customer.getState(),customer
	 * .getCity(),customer.getPhoneNumber(),customer.getEmail(),customer.getPassword
	 * (),customer.getUsername()); }
	 */

@CrossOrigin(origins="*",allowedHeaders="*")
@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
public Customer create(@RequestBody Customer customer) {
//	String encodedPassword = passwordEncoder.encode(customer.getPassword());
	//System.out.println(customer.getFirstName());
	customer = customerService.create(customer);
	return customer;
}


/*
public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String MI,

		@RequestParam String[] addressLines, @RequestParam String zipCode, @RequestParam String state,
		@RequestParam String city) {

	Customer c = customerService.create(firstName, lastName, MI, addressLines, zipCode, state, city);
	return c.toString();
}*/
@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping(value="/getCustomer",method = RequestMethod.GET,produces = "application/json") 
public ResponseEntity<Customer> getCustomer(@RequestParam String email, @RequestHeader Map<String, String> headers) {
	//return customerService.getCustomerByFirstname(firstName);
	return ResponseEntity.ok(customerService.getCustomerByemail(email));
	//ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Person.class);
}

@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping("/getAll")
public List<Customer> getAllCustomer() {
	return customerService.getAll();
}

@CrossOrigin(origins="*",allowedHeaders="*")
@PutMapping(path = "/updateCustomer", consumes = "application/json", produces = "application/json")
public Customer updateCustomer(@RequestBody Customer customer) {
	Customer cust = customerService.updateCustomer(customer);
	return cust;
}
@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping("/delete")
public String deleteCustomer(@RequestParam String firstName) {
	customerService.deleteByFirstName(firstName);
	return "Person Deleted" + firstName;
}
@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping("/deleteAll")
public String deletAll() {
	customerService.deleteAll();
	return "Deleted All Customer";
}

@RequestMapping("/hello")  
public String hello() {   
 return "Hello, world"; 
 }

@CrossOrigin(origins="*",allowedHeaders="*")
@PostMapping(path = "/createClass", consumes = "application/json", produces = "application/json")
public CommunityClass create(@RequestBody CommunityClass commClass) {
//	String encodedPassword = passwordEncoder.encode(customer.getPassword());
	//System.out.println(customer.getFirstName());
	return commService.create(commClass);
}

@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping("/commClass")
public List<CommunityClass> commClass() {
	return commService.getAll();
}


}
