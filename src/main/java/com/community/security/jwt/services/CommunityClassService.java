package com.community.security.jwt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.model.CommunityClass;
import com.community.model.Customer;

@Service
public class CommunityClassService {
	
	@Autowired
	private CommunityClassRepository commReposiroty;
	//create Customer
	public CommunityClass create(CommunityClass commClass) {
		return commReposiroty.save(commClass); 
	}
	public List<CommunityClass> getAll(){
		return commReposiroty.findAll();
	}

}
