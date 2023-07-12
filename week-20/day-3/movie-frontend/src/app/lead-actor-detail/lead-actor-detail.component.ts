import { Component } from '@angular/core';
import { LeadActor } from '../models/lead-actor';
import { BackendService } from '../services/backend.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-lead-actor-detail',
  templateUrl: './lead-actor-detail.component.html',
  styleUrls: ['./lead-actor-detail.component.css']
})
export class LeadActorDetailComponent {

  leadActor: LeadActor = new LeadActor(0, '', 0, 0, '', '');

  // using an ActivatedRoute to draw the leadActorId value from the route itself
  constructor(private backend: BackendService, private ar: ActivatedRoute) {
    this.backend.getLeadActorById(this.ar.snapshot.params['id']);

    this.backend.leadActorDetail.subscribe(data => {
      this.leadActor = data;
    })
  }

}
