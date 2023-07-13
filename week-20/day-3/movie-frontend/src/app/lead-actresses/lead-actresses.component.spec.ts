import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeadActressesComponent } from './lead-actresses.component';
import { LeadActress } from '../models/lead-actress';
import { BackendService } from '../services/backend.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

describe('LeadActressesComponent', () => {
  let component: LeadActressesComponent;
  let fixture: ComponentFixture<LeadActressesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule, FormsModule],
      providers: [BackendService],
      declarations: [LeadActressesComponent]
    });
    fixture = TestBed.createComponent(LeadActressesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // creating a test method to see if our switchUpdate() method works
  it('should update the variables when we run switchUpdate with a valid LeadActress',
     () => {
      component.switchToUpdate(new LeadActress(4, 'Test Name', 99, 3, 'testImgUrl', 'testImdbUrl'));
      expect(component.name).toEqual('Test Name');
     });

  it('should create a valid LeadActress when assembling values after swtichToUpdate',
     () => {
      component.switchToUpdate(new LeadActress(4, 'Test Name', 99, 3, 'testImgUrl', 'testImdbUrl'));
      expect(new LeadActress(component.leadActressId, 
                             component.name, 
                             component.age, 
                             component.academyAwards, 
                             component.imageUrl, 
                             component.imageUrl)).toBeInstanceOf(LeadActress);
     });
    
  });
