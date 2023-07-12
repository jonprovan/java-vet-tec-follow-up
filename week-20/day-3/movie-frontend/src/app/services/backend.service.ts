// to create a service, use ng g s <name>
// a service is an injectable class we can use for any logic we like
// it exists as a singleton and persists, regardless of navigation
// here, we're using it to make backend requests
// and to hold centralized data

import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { LeadActress } from 'src/app/models/lead-actress';
import { LeadActor } from 'src/app/models/lead-actor';
import { Movie } from 'src/app/models/movie';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  baseUrl: String = 'http://localhost:8080/';

  // these are raw arrays containing the returned data from our database
  leadActressesRaw: LeadActress[] = [];
  leadActorsRaw: LeadActor[] = [];
  moviesRaw: Movie[] = [];

  // these are subjects who store the state of the above arrays
  // and notify any Observables when that state has changed
  leadActressesSubject = new BehaviorSubject<LeadActress[]>([]);
  leadActorsSubject = new BehaviorSubject<LeadActor[]>([]);
  moviesSubject = new BehaviorSubject<Movie[]>([]);

  // these are the BehaviorSubjects above exported as Observables
  // other components will subscribe to these and be notified when they change
  leadActresses = this.leadActressesSubject.asObservable();
  leadActors = this.leadActorsSubject.asObservable();
  movies = this.moviesSubject.asObservable();



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

                // this updates the BehaviorSubject with the new array
                this.leadActressesSubject.next(this.leadActressesRaw);

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

                this.leadActorsSubject.next(this.leadActorsRaw);
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

                this.moviesSubject.next(this.moviesRaw);
             });
  }

}
