import { Component, Input } from '@angular/core';
import { LeadActor } from '../models/lead-actor';

@Component({
  selector: 'app-lead-actor',
  templateUrl: './lead-actor.component.html',
  styleUrls: ['./lead-actor.component.css']
})
export class LeadActorComponent {

  @Input() leadActor: LeadActor = new LeadActor(0, '', 0, 0, '', '');

}
