import { Component } from '@angular/core';
import { LeadActress } from '../models/lead-actress';
import { BackendService } from '../services/backend.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-lead-actress-detail',
  templateUrl: './lead-actress-detail.component.html',
  styleUrls: ['./lead-actress-detail.component.css']
})
export class LeadActressDetailComponent {

  leadActress: LeadActress = new LeadActress(0, '', 0, 0, '', '');

  // using an ActivatedRoute to draw the leadActressId value from the route itself
  constructor(private backend: BackendService, private ar: ActivatedRoute) {
    this.backend.getLeadActressById(this.ar.snapshot.params['id']);

    this.backend.leadActressDetail.subscribe(data => {
      this.leadActress = data;
    })
  }

}
