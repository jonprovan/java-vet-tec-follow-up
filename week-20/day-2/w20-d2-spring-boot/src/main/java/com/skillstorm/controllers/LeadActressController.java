package com.skillstorm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.W20D2SpringBootApplication;
import com.skillstorm.models.LeadActress;
import com.skillstorm.services.LeadActressService;

// RestController designates this class as a Controller AND wraps all outgoing responses in an HTTP Response Body
@RestController
// RequestMapping points all requests with this URL suffix to this controller
@RequestMapping("/lead-actress")
public class LeadActressController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(LeadActressController.class);
	
	@Autowired
	private LeadActressService service;
	
	/*
	 * ENDPOINTS:
	 * 
	 * GET -- http://localhost:8080/lead-actress -- returns all LeadActress records
	 * GET -- http://localhost:8080/lead-actress/{leadActressId} -- returns the LeadActress with lead_actress_id leadActressId
	 * POST -- http://localhost:8080/lead-actress -- takes a LeadActress object, returns the created LeadActress object
	 * PUT -- http://localhost:8080/lead-actress -- takes a LeadActress object, returns the updated LeadActress object
	 * DELETE -- http://localhost:8080/lead-actress/{leadActressId} -- deletes the LeadActress with lead_actress_id leadActressId, returns nothing
	 */
	
	// this maps GET requests with no additional suffix to this method
	@GetMapping
	public Iterable<LeadActress> getAllLeadActresses() {
		LOGGER.trace("A trace-level message from our LeadActressController");
		return service.getAll();
	}
	
	// this maps GET requests with a numerical suffix to this method
	@GetMapping("/{leadActressId}")
	public LeadActress getOneLeadActress(@PathVariable int leadActressId) {
		return service.getOne(leadActressId);
	}
	
	// this maps POST requests with no additional suffix to this method
	@PostMapping
	// RequestBody tells us this intake object will come from the body of the POST request
	public LeadActress addOneLeadActress(@RequestBody LeadActress leadActress) {
		return service.addOne(leadActress);
	}
	
	// this maps PUT requests with no additional suffix to this method
	@PutMapping
	public LeadActress updateOneLeadActress(@RequestBody LeadActress leadActress) {
		return service.updateOne(leadActress);
	}
	
	// this maps DELETE requests with a numerical suffix to this method
	@DeleteMapping("/{leadActressId}")
	// the numerical suffix becomes the local variable leadActressId, due to the PathVariable annotation
	public void deleteOneLeadActress(@PathVariable int leadActressId) {
		service.deleteOne(leadActressId);
	}
	

}
