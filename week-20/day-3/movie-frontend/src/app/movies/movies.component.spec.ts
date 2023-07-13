import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviesComponent } from './movies.component';
import { HttpClientModule } from '@angular/common/http';
import { BackendService } from '../services/backend.service';
import { FormsModule } from '@angular/forms';

describe('MoviesComponent', () => {
  let component: MoviesComponent;
  let fixture: ComponentFixture<MoviesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule, FormsModule],
      providers: [BackendService],
      declarations: [MoviesComponent]
    });
    fixture = TestBed.createComponent(MoviesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
