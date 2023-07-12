package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.LeadActor;
import com.skillstorm.models.LeadActress;
import com.skillstorm.services.LeadActorService;

@RestController
@RequestMapping("/lead-actor")
@CrossOrigin(origins = "*")
public class LeadActorController {
	
	@Autowired
	private LeadActorService service;
	
	@GetMapping
	public Iterable<LeadActor> getAllLeadActors() {
		return service.getAll();
	}
	
	@GetMapping("/{leadActorId}")
	public LeadActor getOneLeadActor(@PathVariable int leadActorId) {
		return service.getOne(leadActorId);
	}
	
	@PostMapping
	public LeadActor addOneLeadActor(@RequestBody LeadActor leadActor) {
		return service.addOne(leadActor);
	}
	
	@PutMapping
	public LeadActor updateOneLeadActor(@RequestBody LeadActor leadActor) {
		return service.updateOne(leadActor);
	}
	
	@DeleteMapping("/{leadActorId}")
	public void deleteOneLeadActor(@PathVariable int leadActorId) {
		service.deleteOne(leadActorId);
	}

}
