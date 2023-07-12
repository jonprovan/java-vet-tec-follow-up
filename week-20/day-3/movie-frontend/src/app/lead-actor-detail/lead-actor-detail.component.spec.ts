import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeadActorDetailComponent } from './lead-actor-detail.component';

describe('LeadActorDetailComponent', () => {
  let component: LeadActorDetailComponent;
  let fixture: ComponentFixture<LeadActorDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LeadActorDetailComponent]
    });
    fixture = TestBed.createComponent(LeadActorDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
