// to create a service, use ng g s <name>
// a service is an injectable class we can use for any logic we like
// it exists as a singleton and persists, regardless of navigation
// here, we're using it to make backend requests
// and to hold centralized data

import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  constructor(private http: HttpClient) { }
}
