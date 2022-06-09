import { Observable } from 'rxjs';
import { NodeRef } from './../models/node-ref';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class NodeRefService {
  private url: string = 'http://localhost:8080/sky/api/admin';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<NodeRef[]> {
    return this.httpClient.get<NodeRef[]>(`${this.url}/selectSpirit`);
  }

  public getById(id: number): Observable<NodeRef> {
    return this.httpClient.get<NodeRef>(`${this.url}/selectNodeRef`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/deleteNode/{id}`);
  }
  public update(nodeRef: NodeRef): Observable<NodeRef> {
    return this.httpClient.put<NodeRef>(
      `${this.url}/modifSpirit/{spiritName}`,
      this.moduleToJson(nodeRef)
    );
  }
  private moduleToJson(nodeRef: NodeRef): any {
    let obj = {
      id: nodeRef.id,
      realm: nodeRef.realm,
      spritName: nodeRef.spiritName,
    };
    return obj;
  }

  public create(nodeRef: NodeRef): Observable<NodeRef> {
    return this.httpClient.post<NodeRef>(
      `${this.url}/createNode`,
      this.moduleToJson(nodeRef)
    );
  }
}
