import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LeadActressesComponent } from './lead-actresses/lead-actresses.component';
import { LeadActorsComponent } from './lead-actors/lead-actors.component';
import { MoviesComponent } from './movies/movies.component';
import { LeadActressDetailComponent } from './lead-actress-detail/lead-actress-detail.component';
import { LeadActorDetailComponent } from './lead-actor-detail/lead-actor-detail.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';

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
    path: 'lead-actress/:id',
    component: LeadActressDetailComponent
  },
  {
    path: 'lead-actors',
    component: LeadActorsComponent
  },
  {
    path: 'lead-actor/:id',
    component: LeadActorDetailComponent
  },
  {
    path: 'movies',
    component: MoviesComponent
  },
  {
    path: 'movie/:id',
    component: MovieDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
