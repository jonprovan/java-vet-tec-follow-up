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

  // these are for holding our form data before sending it to the service
  leadActorId: number = 0;
  name: string = '';
  age: number = 0;
  academyAwards: number = 0;
  imageUrl: string = '';
  imdbUrl: string = '';

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

  // using our ngModeled form to send a lead actor to our service
  addLeadActor() {
    this.bes.addLeadActor(new LeadActor(0, 
                                            this.name, 
                                            this.age, 
                                            this.academyAwards,
                                            this.imageUrl,
                                            this.imdbUrl));
  }

  // this runs when the user clicks the update button in a child component
  switchToUpdate(leadActor: LeadActor) {
    this.leadActorId = leadActor.leadActorId;
    this.name = leadActor.name;
    this.age = leadActor.age;
    this.academyAwards = leadActor.academyAwards;
    this.imageUrl = leadActor.imageUrl;
    this.imdbUrl = leadActor.imdbUrl;
  }

  // this gets back to the add form
  cancelUpdate() {
    this.leadActorId = 0;
    this.name = '';
    this.age = 0;
    this.academyAwards = 0;
    this.imageUrl = '';
    this.imdbUrl = '';
  }

  // this updates the lead actor in the database
  updateLeadActor() {
    this.bes.updateLeadActor(new LeadActor(this.leadActorId, 
                                           this.name, 
                                           this.age, 
                                           this.academyAwards,
                                           this.imageUrl,
                                           this.imdbUrl));
    this.leadActorId = 0;
  }

}
