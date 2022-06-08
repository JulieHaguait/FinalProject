import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root',
})
export class InscriptionService {
  url = 'http://localhost:8080/sky/api/auth';

  constructor(private httpClient: HttpClient) {}

  public inscription(user: any): Observable<User> {
    return this.httpClient.post<User>(this.url + '/inscription', user);
  }

  public checkLogin(login: string): Observable<boolean> {
    return this.httpClient.get<boolean>(this.url + '/login/' + login);
  }

  /*
  private get headers(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Basic ' + btoa('admin:admin'),
    });
  }*/
}
