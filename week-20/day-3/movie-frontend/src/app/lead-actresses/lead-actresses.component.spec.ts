import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeadActressesComponent } from './lead-actresses.component';

describe('LeadActressesComponent', () => {
  let component: LeadActressesComponent;
  let fixture: ComponentFixture<LeadActressesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LeadActressesComponent]
    });
    fixture = TestBed.createComponent(LeadActressesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
