import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/index";
import {User} from "../model/user.model";
import {ApiResponse} from "../model/api.response";

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }

  readonly baseUrl: string = ''; // http://localhost:7001/azure-demo-app/

  readonly usersUrl: string = this.baseUrl + 'users/';
  readonly tokenUrl: string = this.baseUrl + 'token/generate-token';

  login(loginPayload) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.tokenUrl, loginPayload);
  }

  getUsers() : Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.usersUrl);
  }

  getUserById(id: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.usersUrl + id);
  }

  createUser(user: User): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.usersUrl, user);
  }

  updateUser(user: User): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.usersUrl + user.id, user);
  }

  deleteUser(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.usersUrl + id);
  }
}
