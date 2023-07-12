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

  constructor(private bes: BackendService) {
    this.bes.leadActors.subscribe(data => {
      this.leadActors = data;
    });
  }

}
