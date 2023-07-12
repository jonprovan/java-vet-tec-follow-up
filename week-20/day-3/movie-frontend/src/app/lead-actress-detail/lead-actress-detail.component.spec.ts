import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeadActressDetailComponent } from './lead-actress-detail.component';

describe('LeadActressDetailComponent', () => {
  let component: LeadActressDetailComponent;
  let fixture: ComponentFixture<LeadActressDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LeadActressDetailComponent]
    });
    fixture = TestBed.createComponent(LeadActressDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
