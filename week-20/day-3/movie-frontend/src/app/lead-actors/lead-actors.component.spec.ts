import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeadActorsComponent } from './lead-actors.component';
import { HttpClientModule } from '@angular/common/http';
import { BackendService } from '../services/backend.service';
import { FormsModule } from '@angular/forms';

describe('LeadActorsComponent', () => {
  let component: LeadActorsComponent;
  let fixture: ComponentFixture<LeadActorsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule, FormsModule],
      providers: [BackendService],
      declarations: [LeadActorsComponent]
    });
    fixture = TestBed.createComponent(LeadActorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
