import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { MoviesComponent } from './movies/movies.component';
import { LeadActorsComponent } from './lead-actors/lead-actors.component';
import { LeadActressesComponent } from './lead-actresses/lead-actresses.component';
import { HomeComponent } from './home/home.component';
import { LeadActressComponent } from './lead-actress/lead-actress.component';
import { LeadActorComponent } from './lead-actor/lead-actor.component';
import { MovieComponent } from './movie/movie.component';
import { TruncatePipe } from './pipes/truncate.pipe';
import { LeadActressDetailComponent } from './lead-actress-detail/lead-actress-detail.component';
import { LeadActorDetailComponent } from './lead-actor-detail/lead-actor-detail.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavComponent,
    FooterComponent,
    MoviesComponent,
    LeadActorsComponent,
    LeadActressesComponent,
    HomeComponent,
    LeadActressComponent,
    LeadActorComponent,
    MovieComponent,
    TruncatePipe,
    LeadActressDetailComponent,
    LeadActorDetailComponent,
    MovieDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
