package com.community.security.jwt.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.community.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String > {
//@Query("{'user.email': ?0}")
//List<Person> findByCountry(final String country);
public Customer findByFirstName(String firstName);//user name is email
public Customer findByEmail(String email);


}
