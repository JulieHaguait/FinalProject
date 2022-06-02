import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  public auth(login: string, password: string): Observable<User> {
    let monHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(`${login}:${password}`),
    });
    return this.httpClient.get<User>('http://localhost:8080/boot/api/auth', {
      headers: monHeaders,
    });
  }

  public get authenticated(): boolean {
    return sessionStorage.getItem('token') ? true : false;
  }

  constructor(private httpClient: HttpClient) {}
}
