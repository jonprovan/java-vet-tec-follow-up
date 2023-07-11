package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.LeadActor;
import com.skillstorm.models.LeadActress;
import com.skillstorm.repositories.LeadActorRepository;

@Service
public class LeadActorService {
	
	@Autowired
	private LeadActorRepository repo;
	
	// getting all LeadActors
	public Iterable<LeadActor> getAll() {
		return repo.findAll();
	}
	
	// creating a single new LeadActor record
	public LeadActor addOne(LeadActor leadActor) {
		// setting the id to 0 before saving, so we don't update an existing record by accident
		leadActor.setLeadActorId(0);
		return repo.save(leadActor);
	}
	
	// deleting a single LeadActor record
	public void deleteOne(int leadActorId) {
		// we must check if this record exists before trying to delete it
		if (repo.existsById(leadActorId))
			repo.deleteById(leadActorId);
	}

}
