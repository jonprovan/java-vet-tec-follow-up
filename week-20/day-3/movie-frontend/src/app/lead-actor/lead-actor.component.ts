import { Component, Input } from '@angular/core';
import { LeadActor } from '../models/lead-actor';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lead-actor',
  templateUrl: './lead-actor.component.html',
  styleUrls: ['./lead-actor.component.css']
})
export class LeadActorComponent {

  @Input() leadActor: LeadActor = new LeadActor(0, '', 0, 0, '', '');

   // injecting a router to use for the detail links
   constructor(private router: Router) {}

   // routing to the details page for this actress using her ID
   getDetails() {
     this.router.navigate(['lead-actor/' + this.leadActor.leadActorId]);
   }

}
