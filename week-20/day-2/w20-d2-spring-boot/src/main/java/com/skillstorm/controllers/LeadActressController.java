package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.LeadActress;
import com.skillstorm.services.LeadActressService;

// RestController designates this class as a Controller AND wraps all outgoing responses in an HTTP Response Body
@RestController
// RequestMapping points all requests with this URL suffix to this controller
@RequestMapping("/lead-actress")
public class LeadActressController {
	
	@Autowired
	private LeadActressService service;
	
	// this maps GET requests with no suffix to this method
	// ENDPOINT = GET request to http://localhost:8080/lead-actress, return all LeadActress records
	@GetMapping
	public Iterable<LeadActress> getAllLeadActresses() {
		return service.getAll();
	}
	

}
