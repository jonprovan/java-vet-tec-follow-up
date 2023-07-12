import { Component } from '@angular/core';
import { BackendService } from 'src/services/backend.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'movie-frontend';

  constructor(private backend: BackendService) {}
}
