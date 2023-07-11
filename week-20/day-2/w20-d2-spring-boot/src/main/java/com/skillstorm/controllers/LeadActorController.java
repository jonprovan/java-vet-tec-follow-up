package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.LeadActor;
import com.skillstorm.models.LeadActress;
import com.skillstorm.services.LeadActorService;

@RestController
@RequestMapping("/lead-actor")
public class LeadActorController {
	
	@Autowired
	private LeadActorService service;
	
	@GetMapping
	public Iterable<LeadActor> getAllLeadActors() {
		return service.getAll();
	}

}
