import { Component } from '@angular/core';
import { LeadActor } from '../models/lead-actor';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-lead-actors',
  templateUrl: './lead-actors.component.html',
  styleUrls: ['./lead-actors.component.css']
})
export class LeadActorsComponent {

  leadActors: LeadActor[] = [];
  activeLeadActorIds: number[] = [];

  constructor(private bes: BackendService) {
    this.bes.leadActors.subscribe(data => {
      this.leadActors = data;
    });

    this.bes.movies.subscribe(data => {
      this.activeLeadActorIds = [];
      for (let movie of data) {
        this.activeLeadActorIds.push(movie.leadActor.leadActorId);
      }
    });
  }

  moveLeadActor(direction: string, index: number) {
    if (direction === 'left') {
      this.leadActors.splice(index - 1, 0, ...this.leadActors.splice(index, 1));
    } else {
      this.leadActors.splice(index + 1, 0, ...this.leadActors.splice(index, 1));
    }
  }

}
