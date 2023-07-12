import { Component, Input } from '@angular/core';
import { LeadActress } from '../models/lead-actress';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lead-actress',
  templateUrl: './lead-actress.component.html',
  styleUrls: ['./lead-actress.component.css']
})
export class LeadActressComponent {

  // this Input variable will get filled with
  // whichever LeadActress we pass down from the parent
  @Input() leadActress: LeadActress = new LeadActress(0, '', 0, 0, '', '');

  // injecting a router to use for the detail links
  constructor(private router: Router) {}

  // routing to the details page for this actress using her ID
  getDetails() {
    this.router.navigate(['lead-actress/' + this.leadActress.leadActressId]);
  }
}
