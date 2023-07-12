import { Component } from '@angular/core';
import { Movie } from '../models/movie';
import { BackendService } from '../services/backend.service';
import { ActivatedRoute } from '@angular/router';
import { LeadActor } from '../models/lead-actor';
import { LeadActress } from '../models/lead-actress';

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})
export class MovieDetailComponent {

  movie: Movie = new Movie(0, '', '', 0,
                 new LeadActor(0, '', 0, 0, '', ''),
                 new LeadActress(0, '', 0, 0, '', ''),
                 0, '', '');

  // using an ActivatedRoute to draw the leadActressId value from the route itself
  constructor(private backend: BackendService, private ar: ActivatedRoute) {
    this.backend.getMovieById(this.ar.snapshot.params['id']);

    this.backend.movieDetail.subscribe(data => {
      this.movie = data;
    })
  }

}
