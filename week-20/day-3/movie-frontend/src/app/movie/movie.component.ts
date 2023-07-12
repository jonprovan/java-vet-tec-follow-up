import { Component, Input } from '@angular/core';
import { Movie } from '../models/movie';
import { LeadActor } from '../models/lead-actor';
import { LeadActress } from '../models/lead-actress';

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

}
