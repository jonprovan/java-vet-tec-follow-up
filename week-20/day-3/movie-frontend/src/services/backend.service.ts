// to create a service, use ng g s <name>
// a service is an injectable class we can use for any logic we like
// it exists as a singleton and persists, regardless of navigation
// here, we're using it to make backend requests
// and to hold centralized data

import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { LeadActress } from 'src/models/lead-actress';
import { LeadActor } from 'src/models/lead-actor';
import { Movie } from 'src/models/movie';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  baseUrl: String = 'http://localhost:8080/';
  leadActressesRaw: LeadActress[] = [];
  leadActorsRaw: LeadActor[] = [];
  moviesRaw: Movie[] = [];

  constructor(private http: HttpClient) {
    this.getAllLeadActresses();
    this.getAllLeadActors();
    this.getAllMovies();
  }

  // getting all lead actresses
  getAllLeadActresses() {
    this.http.get(this.baseUrl + 'lead-actress', { observe: 'response' })
             .subscribe(data => {
                this.leadActressesRaw = [];

                let temp: any = data.body;

                for (let item of temp) {
                  this.leadActressesRaw.push(new LeadActress(item.leadActressId,
                                                             item.name,
                                                             item.age,
                                                             item.academyAwards,
                                                             item.imageUrl,
                                                             item.imdbUrl));
                }

                console.log(this.leadActressesRaw);
             });
  }

  // getting all lead actors
  getAllLeadActors() {
    this.http.get(this.baseUrl + 'lead-actor', { observe: 'response' })
             .subscribe(data => {
                this.leadActorsRaw = [];

                let temp: any = data.body;

                for (let item of temp) {
                  this.leadActorsRaw.push(new LeadActor(item.leadActorId,
                                                        item.name,
                                                        item.age,
                                                        item.academyAwards,
                                                        item.imageUrl,
                                                        item.imdbUrl));
                }

                console.log(this.leadActorsRaw);
             });
  }

  // getting all movies
  getAllMovies() {
    this.http.get(this.baseUrl + 'movie', { observe: 'response' })
             .subscribe(data => {
                this.moviesRaw = [];
                
                let temp: any = data.body;

                for (let item of temp) {
                  this.moviesRaw.push(new Movie(item.movieId,
                                                item.name,
                                                item.genre,
                                                item.releaseYear,
                                                new LeadActor(item.leadActor.leadActorId,
                                                              item.leadActor.name,
                                                              item.leadActor.age,
                                                              item.leadActor.academyAwards,
                                                              item.leadActor.imageUrl,
                                                              item.leadActor.imdbUrl),
                                                new LeadActress(item.leadActress.leadActressId,
                                                                item.leadActress.name,
                                                                item.leadActress.age,
                                                                item.leadActress.academyAwards,
                                                                item.leadActress.imageUrl,
                                                                item.leadActress.imdbUrl),
                                                item.boxOfficeGross,
                                                item.imageUrl,
                                                item.imdbUrl));
                }

                console.log(this.moviesRaw);
             });
  }

}
