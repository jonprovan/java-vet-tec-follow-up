import { Component } from '@angular/core';
import { LeadActress } from '../models/lead-actress';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-lead-actresses',
  templateUrl: './lead-actresses.component.html',
  styleUrls: ['./lead-actresses.component.css']
})
export class LeadActressesComponent {

  leadActresses: LeadActress[] = [];

  // in our constructor, we subscribe to the Observable
  // holding the current LeadActress[]
  constructor(private bes: BackendService) {
    this.bes.leadActresses.subscribe(data => {
      this.leadActresses = data;
    });
  }

}
