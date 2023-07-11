package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.LeadActor;
import com.skillstorm.repositories.LeadActorRepository;

@Service
public class LeadActorService {
	
	@Autowired
	private LeadActorRepository repo;
	
	public Iterable<LeadActor> getAll() {
		return repo.findAll();
	}

}
