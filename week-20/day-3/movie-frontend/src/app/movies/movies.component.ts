import { Component } from '@angular/core';
import { Movie } from '../models/movie';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent {

  movies: Movie[] = [];

  constructor(private bes: BackendService) {
    this.bes.movies.subscribe(data => {
      this.movies = data;
    });
  }

}
