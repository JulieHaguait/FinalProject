import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
@Injectable({
  providedIn: 'root',
})
export class InscriptionService {
  url = '';

  constructor(private http: HttpClient) {}

  public inscription(user: any): Observable<User> {
    return this.http.post<User>(this.url + '/inscription', user);
  }

  public checkLogin(login: string): Observable<boolean> {
    return this.http.get<boolean>(this.url + '/login/' + login);
  }
}
