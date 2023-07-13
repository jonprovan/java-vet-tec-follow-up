import { Component } from '@angular/core';
import { LeadActress } from '../models/lead-actress';
import { BackendService } from '../services/backend.service';
import { Movie } from '../models/movie';

@Component({
  selector: 'app-lead-actresses',
  templateUrl: './lead-actresses.component.html',
  styleUrls: ['./lead-actresses.component.css']
})
export class LeadActressesComponent {

  leadActresses: LeadActress[] = [];
  activeLeadActressIds: number[] = [];

  // in our constructor, we subscribe to the Observable
  // holding the current LeadActress[]
  constructor(private bes: BackendService) {
    this.bes.leadActresses.subscribe(data => {
      this.leadActresses = data;
    });

    this.bes.movies.subscribe(data => {
      this.activeLeadActressIds = [];
      for (let movie of data) {
        this.activeLeadActressIds.push(movie.leadActress.leadActressId);
      }
    });
  }

  moveLeadActress(direction: string, index: number) {
    if (direction === 'left') {
      this.leadActresses.splice(index - 1, 0, ...this.leadActresses.splice(index, 1));
    } else {
      this.leadActresses.splice(index + 1, 0, ...this.leadActresses.splice(index, 1));
    }
  }

}
