import { Component, EventEmitter, Input, Output } from '@angular/core';
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

  // Inputs receive data from the parent component
  @Input() movie: Movie = new Movie(0, '', '', 0,
                                    new LeadActor(0, '', 0, 0, '', ''),
                                    new LeadActress(0, '', 0, 0, '', ''),
                                    0, '', '');
  @Input() index: number = 0;
  @Input() lastIndex: number = 0;

  // Outputs send data to the parent component
  // in the form of an event
  @Output() moveMovieEvent = new EventEmitter<string>();

  // injecting a router to use for the detail links
  constructor(private router: Router) {}

  // routing to the details page for this actress using her ID
  getDetails() {
    this.router.navigate(['movie/' + this.movie.movieId]);
  }

  // a method that fires whenever the user clicks on the L/R buttons
  moveMovie(direction: string) {
    this.moveMovieEvent.emit(direction);
  }

}
