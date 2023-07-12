import { Component, Input } from '@angular/core';
import { Movie } from '../models/movie';
import { LeadActor } from '../models/lead-actor';
import { LeadActress } from '../models/lead-actress';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent {

  @Input() movie: Movie = new Movie(0, '', '', 0,
                                    new LeadActor(0, '', 0, 0, '', ''),
                                    new LeadActress(0, '', 0, 0, '', ''),
                                    0, '', '');

  // injecting a router to use for the detail links
  constructor(private router: Router) {}

  // routing to the details page for this actress using her ID
  getDetails() {
    this.router.navigate(['movie/' + this.movie.movieId]);
  }

}
