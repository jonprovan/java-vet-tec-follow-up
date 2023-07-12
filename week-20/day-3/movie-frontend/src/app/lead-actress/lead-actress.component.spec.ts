import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeadActressComponent } from './lead-actress.component';

describe('LeadActressComponent', () => {
  let component: LeadActressComponent;
  let fixture: ComponentFixture<LeadActressComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LeadActressComponent]
    });
    fixture = TestBed.createComponent(LeadActressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
