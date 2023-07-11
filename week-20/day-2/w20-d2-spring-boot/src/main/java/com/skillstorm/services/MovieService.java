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
	
	public Iterable<Movie> getAll() {
		return repo.findAll();
	}
	
	// creating a single new Movie record
	public Movie addOne(Movie movie) {
		// setting the id to 0 before saving, so we don't update an existing record by accident
		movie.setMovieId(0);
		return repo.save(movie);
	}
	
	// deleting a single Movie record
	public void deleteOne(int movieId) {
		// we must check if this record exists before trying to delete it
		if (repo.existsById(movieId))
			repo.deleteById(movieId);
	}

}
