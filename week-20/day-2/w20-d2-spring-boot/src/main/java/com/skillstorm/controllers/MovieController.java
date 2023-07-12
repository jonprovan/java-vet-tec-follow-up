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
import com.skillstorm.models.Movie;
import com.skillstorm.services.MovieService;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "*")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public Iterable<Movie> getAllMovies() {
		return service.getAll();
	}
	
	@GetMapping("/{movieId}")
	public Movie getOneMovie(@PathVariable int movieId) {
		return service.getOne(movieId);
	}
	
	@PostMapping
	public Movie addOneMovie(@RequestBody Movie movie) {
		return service.addOne(movie);
	}
	
	@PutMapping
	public Movie updateOneMovie(@RequestBody Movie movie) {
		return service.updateOne(movie);
	}
	
	@DeleteMapping("/{movieId}")
	public void deleteOneMovie(@PathVariable int movieId) {
		service.deleteOne(movieId);
	}

}
