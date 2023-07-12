import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LeadActressesComponent } from './lead-actresses/lead-actresses.component';
import { LeadActorsComponent } from './lead-actors/lead-actors.component';
import { MoviesComponent } from './movies/movies.component';

// each component you want to send to your router outlet
// must have a route configured here
const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'lead-actresses',
    component: LeadActressesComponent
  },
  {
    path: 'lead-actors',
    component: LeadActorsComponent
  },
  {
    path: 'movies',
    component: MoviesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
