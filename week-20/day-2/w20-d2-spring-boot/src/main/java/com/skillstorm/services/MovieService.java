package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.LeadActor;
import com.skillstorm.models.Movie;
import com.skillstorm.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repo;
	
	// getting all Movie records
	public Iterable<Movie> getAll() {
		return repo.findAll();
	}
	
	// getting a single Movie record
	public Movie getOne(int movieId) {
		// checking to see if the id is associated with a database record
		if (repo.findById(movieId).isPresent())
			// if so, return the object
			return repo.findById(movieId).get();
		else
			// if not, return null
			return null;
	}
	
	// creating a single new Movie record
	public Movie addOne(Movie movie) {
		// setting the id to 0 before saving, so we don't update an existing record by accident
		movie.setMovieId(0);
		return repo.save(movie);
	}
	
	// updating a single Movie record
	public Movie updateOne(Movie movie) {
		if (repo.findById(movie.getMovieId()).isPresent())
			return repo.save(movie);
		else
			return null;
	}
	
	// deleting a single Movie record
	public void deleteOne(int movieId) {
		// we must check if this record exists before trying to delete it
		if (repo.existsById(movieId))
			repo.deleteById(movieId);
	}

}
