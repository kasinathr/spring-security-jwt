package com.community.security.jwt.services;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.community.model.CommunityClass;
import com.community.model.Customer;

public interface CommunityClassRepository extends MongoRepository<CommunityClass, String > {
	public List<CommunityClass> findAll();

}
