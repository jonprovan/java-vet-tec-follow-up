import { Component } from '@angular/core';
import { Movie } from '../models/movie';
import { BackendService } from '../services/backend.service';
import { LeadActor } from '../models/lead-actor';
import { LeadActress } from '../models/lead-actress';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent {

  movies: Movie[] = [];
  leadActors: LeadActor[] = [];
  leadActresses: LeadActress[] = [];

  // these are for holding our form data before sending it to the service
  movieId: number = 0;
  name: string = '';
  genre: string = '';
  releaseYear: number = 0;
  leadActorIndex: number = 0;
  leadActressIndex: number = 0;
  boxOfficeGross: number = 0;
  imageUrl: string = '';
  imdbUrl: string = '';

  constructor(private bes: BackendService) {
    this.bes.movies.subscribe(data => {
      this.movies = data;
    });

    this.bes.leadActors.subscribe(data => {
      this.leadActors = data;
    });

    this.bes.leadActresses.subscribe(data => {
      this.leadActresses = data;
    });
  }

  moveMovie(direction: string, index: number) {
    if (direction === 'left') {
      this.movies.splice(index - 1, 0, ...this.movies.splice(index, 1));
    } else {
      this.movies.splice(index + 1, 0, ...this.movies.splice(index, 1));
    }
  }

  // using our ngModeled form to send a movie to our service
  addMovie() {
    this.bes.addMovie(new Movie(0, 
                                this.name,
                                this.genre,
                                this.releaseYear,
                                this.leadActors[this.leadActorIndex],
                                this.leadActresses[this.leadActressIndex],
                                this.boxOfficeGross,
                                this.imageUrl,
                                this.imdbUrl));
  }

  // this runs when the user clicks the update button in a child component
  switchToUpdate(movie: Movie) {
    this.movieId = movie.movieId;
    this.name = movie.name;
    this.genre = movie.genre;
    this.releaseYear = movie.releaseYear;
    this.leadActorIndex = this.leadActors.findIndex(leadActor => leadActor.leadActorId === movie.leadActor.leadActorId);
    this.leadActressIndex = this.leadActresses.findIndex(leadActress => leadActress.leadActressId === movie.leadActress.leadActressId);
    this.boxOfficeGross = movie.boxOfficeGross;
    this.imageUrl = movie.imageUrl;
    this.imdbUrl = movie.imdbUrl;
  }

  // this gets back to the add form
  cancelUpdate() {
    this.movieId = 0;
    this.name = '';
    this.genre = '';
    this.releaseYear = 0;
    this.leadActorIndex = 0;
    this.leadActressIndex = 0;
    this.boxOfficeGross = 0;
    this.imageUrl = '';
    this.imdbUrl = '';
  }

  // this updates the movie in the database
  updateMovie() {
    this.bes.updateMovie(new Movie(this.movieId, 
                                   this.name, 
                                   this.genre, 
                                   this.releaseYear,
                                   this.leadActors[this.leadActorIndex],
                                   this.leadActresses[this.leadActressIndex],
                                   this.boxOfficeGross,
                                   this.imageUrl,
                                   this.imdbUrl));
    this.movieId = 0;
  }

}
