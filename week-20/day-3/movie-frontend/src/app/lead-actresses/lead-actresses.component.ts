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
  activeLeadActressIds: number[] = [];

  // these are for holding our form data before sending it to the service
  leadActressId: number = 0;
  name: string = '';
  age: number = 0;
  academyAwards: number = 0;
  imageUrl: string = '';
  imdbUrl: string = '';


  // in our constructor, we subscribe to the Observable
  // holding the current LeadActress[]
  constructor(private bes: BackendService) {
    this.bes.leadActresses.subscribe(data => {
      this.leadActresses = data;
    });

    this.bes.movies.subscribe(data => {
      this.activeLeadActressIds = [];
      for (let movie of data) {
        this.activeLeadActressIds.push(movie.leadActress.leadActressId);
      }
    });
  }

  moveLeadActress(direction: string, index: number) {
    if (direction === 'left') {
      this.leadActresses.splice(index - 1, 0, ...this.leadActresses.splice(index, 1));
    } else {
      this.leadActresses.splice(index + 1, 0, ...this.leadActresses.splice(index, 1));
    }
  }

  // using our ngModeled form to send a lead actress to our service
  addLeadActress() {
    this.bes.addLeadActress(new LeadActress(0, 
                                            this.name, 
                                            this.age, 
                                            this.academyAwards,
                                            this.imageUrl,
                                            this.imdbUrl));
  }

  // this runs when the user clicks the update button in a child component
  switchToUpdate(leadActress: LeadActress) {
    this.leadActressId = leadActress.leadActressId;
    this.name = leadActress.name;
    this.age = leadActress.age;
    this.academyAwards = leadActress.academyAwards;
    this.imageUrl = leadActress.imageUrl;
    this.imdbUrl = leadActress.imdbUrl;
  }

  // this gets back to the add form
  cancelUpdate() {
    this.leadActressId = 0;
    this.name = '';
    this.age = 0;
    this.academyAwards = 0;
    this.imageUrl = '';
    this.imdbUrl = '';
  }

  // this updates the lead actress in the database
  updateLeadActress() {
    this.bes.updateLeadActress(new LeadActress(this.leadActressId, 
                                           this.name, 
                                           this.age, 
                                           this.academyAwards,
                                           this.imageUrl,
                                           this.imdbUrl));
    this.leadActressId = 0;
  }

}
