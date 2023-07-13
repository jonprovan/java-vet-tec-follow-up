import { Component, EventEmitter, Input, Output } from '@angular/core';
import { LeadActress } from '../models/lead-actress';
import { Router } from '@angular/router';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-lead-actress',
  templateUrl: './lead-actress.component.html',
  styleUrls: ['./lead-actress.component.css']
})
export class LeadActressComponent {

  // this Input variable will get filled with
  // whichever LeadActress we pass down from the parent
  @Input() leadActress: LeadActress = new LeadActress(0, '', 0, 0, '', '');
  @Input() active: boolean = false;
  @Input() index: number = 0;
  @Input() lastIndex: number = 0;

  // Outputs send data to the parent component
  // in the form of an event
  @Output() moveLeadActressEvent = new EventEmitter<string>();

  // injecting a router to use for the detail links
  constructor(private router: Router, private backend: BackendService) {}

  // routing to the details page for this actress using her ID
  getDetails() {
    this.router.navigate(['lead-actress/' + this.leadActress.leadActressId]);
  }

  // a method that fires whenever the user clicks on the L/R buttons
  moveLeadActress(direction: string) {
    this.moveLeadActressEvent.emit(direction);
  }

  // calling our service method for deleting a lead actress
  deleteLeadActress() {
    this.backend.deleteLeadActressById(this.leadActress.leadActressId);
  }
}
