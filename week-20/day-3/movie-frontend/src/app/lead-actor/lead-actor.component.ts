import { Component, EventEmitter, Input, Output } from '@angular/core';
import { LeadActor } from '../models/lead-actor';
import { Router } from '@angular/router';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-lead-actor',
  templateUrl: './lead-actor.component.html',
  styleUrls: ['./lead-actor.component.css']
})
export class LeadActorComponent {

  @Input() leadActor: LeadActor = new LeadActor(0, '', 0, 0, '', '');
  @Input() active: boolean = false;
  @Input() index: number = 0;
  @Input() lastIndex: number = 0;

  // Outputs send data to the parent component
  // in the form of an event
  @Output() moveLeadActorEvent = new EventEmitter<string>();
  @Output() updateLeadActorEvent = new EventEmitter<LeadActor>();

   // injecting a router to use for the detail links
   constructor(private router: Router, private backend: BackendService) {}

   // routing to the details page for this actress using her ID
   getDetails() {
     this.router.navigate(['lead-actor/' + this.leadActor.leadActorId]);
   }

   // a method that fires whenever the user clicks on the L/R buttons
  moveLeadActor(direction: string) {
    this.moveLeadActorEvent.emit(direction);
  }

  // sending this LeadActor up to be updated
  updateLeadActor() {
    this.updateLeadActorEvent.emit(this.leadActor);
  }

   // calling our service method for deleting a lead actor
  deleteLeadActor() {
    this.backend.deleteLeadActorById(this.leadActor.leadActorId);
  }

}
