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
	
	// creating a single new LeadActress record
	public LeadActress addOne(LeadActress leadActress) {
		// setting the id to 0 before saving, so we don't update an existing record by accident
		leadActress.setLeadActressId(0);
		return repo.save(leadActress);
	}
	
	// deleting a single LeadActress record
	public void deleteOne(int leadActressId) {
		// we must check if this record exists before trying to delete it
		if (repo.existsById(leadActressId))
			repo.deleteById(leadActressId);
	}

}
