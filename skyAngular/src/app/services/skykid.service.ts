import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SkykidService {
  private url: string = 'http://localhost:8080/sky/api/admin';

  constructor(private httpClient: HttpClient) {}

  public getAllSkykid(): Observable<User[]> {
    return this.httpClient.get<User[]>(`${this.url}/modifUser`);
  }

  public getById(id: number): Observable<User> {
    return this.httpClient.get<User>(`${this.url}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public update(user: User): Observable<User> {
    return this.httpClient.patch<User>(
      `${this.url}/modifUser`,
      this.userToJson(user)
    );
  }
  private userToJson(user: User): any {
    let obj = {
      id: user.id,
      login: user.login,
    };
    return obj;
  }
}
