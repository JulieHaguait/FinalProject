import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SkykidService {
  private urlAdmin: string = 'http://localhost:8080/sky/api/admin';

  constructor(private httpClient: HttpClient) {}

  public getAllSkykid(): Observable<User[]> {
    return this.httpClient.get<User[]>(`${this.urlAdmin}/modifUser`);
  }

  public getById(id: number): Observable<User> {
    return this.httpClient.get<User>(`${this.urlAdmin}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.urlAdmin}/deleteUser/${id}`);
  }

  public update(user: User): Observable<User> {
    return this.httpClient.patch<User>(
      `${this.urlAdmin}/modifUser`,
      this.userToJson(user)
    );
  }
  private userToJson(user: User): any {
    let obj = {
      id: user.id,
      login: user.login,
      type: user.type,
    };
    return obj;
  }

  private urlSkykid: string = 'http://localhost:8080/sky/api/skykid';

  // get des infos d'un skykid
  public getSkykidById(id: number): Observable<any> {
    return this.httpClient.get<any>(`${this.urlSkykid}/${id}/gestion`);
  }

  // patch pour l'update
  public updateSkykid(skykid: any) {
    return this.httpClient.patch<any>(
      `${this.urlSkykid}/${skykid.id}/gestion`,
      skykid
    );
  }
}
