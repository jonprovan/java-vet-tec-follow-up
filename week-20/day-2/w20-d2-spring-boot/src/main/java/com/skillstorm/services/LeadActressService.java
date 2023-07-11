package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.LeadActress;
import com.skillstorm.repositories.LeadActressRepository;

// Service designates this as an injectable bean that can hold business logic
// to be executed prior to or after database access via the repository
@Service
public class LeadActressService {
	
	// Autowired injects another bean that we need access to
	@Autowired
	private LeadActressRepository repo;
	
	// getting all LeadActress records
	public Iterable<LeadActress> getAll() {
		return repo.findAll();
	}

}
