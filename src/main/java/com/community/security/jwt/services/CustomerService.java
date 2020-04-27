package com.community.security.jwt.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.model.Address;
import com.community.model.CommunityClass;
import com.community.model.Customer;

@Service
public class CustomerService {
@Autowired
private CustomerRepository customerReposiroty;
//create Customer
public Customer create(Customer customer) {
	return customerReposiroty.save(new Customer(customer.getFirstName(),customer.getLastName(),customer.getPhoneNumber(),customer.getPassword(),customer.getEmail(),customer.getRole(),customer.getAddress(),customer.getCoach())); 
}

public List<Customer> getAll(){
	return customerReposiroty.findAll();
}
public Customer getCustomerByFirstname(String firstName) {
	return customerReposiroty.findByFirstName(firstName);
	
}
public Customer getCustomerByUsername(String userName) {
	return customerReposiroty.findByEmail(userName);
	
}

public void deleteAll() {
	customerReposiroty.deleteAll();
}

public void deleteByFirstName(String firstName) {
//Customer custo = customerReposiroty.findByFirstName(firstName);
//customerReposiroty.delete(custo);
	
}
public Customer updateCustomer(Customer inCustomer) {
	
	Customer DBcust = customerReposiroty.findByEmail(inCustomer.getEmail());
	DBcust.setFirstName(inCustomer.getFirstName());
	DBcust.getRole().addAll(inCustomer.getRole());

	DBcust.setLastName(inCustomer.getLastName());
	DBcust.setPhoneNumber(inCustomer.getPhoneNumber());
	DBcust.setAddress(inCustomer.getAddress());
	DBcust.setCoach(inCustomer.getCoach());
	DBcust.setCreateUpdate(new Date(System.currentTimeMillis()));
	return customerReposiroty.save(DBcust);
	
}

public Customer getCustomerByemail(String email) {
	// TODO Auto-generated method stub
	return customerReposiroty.findByEmail(email);
}



}
