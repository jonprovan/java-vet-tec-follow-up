package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.LeadActress;
import com.skillstorm.models.Movie;
import com.skillstorm.services.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public Iterable<Movie> getAllMovies() {
		return service.getAll();
	}

}
