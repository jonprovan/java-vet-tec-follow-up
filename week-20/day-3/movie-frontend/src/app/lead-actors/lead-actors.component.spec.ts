import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeadActorsComponent } from './lead-actors.component';

describe('LeadActorsComponent', () => {
  let component: LeadActorsComponent;
  let fixture: ComponentFixture<LeadActorsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
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
