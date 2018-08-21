import { Injectable } from '@angular/core';
import { Http, Response, Headers  } from '@angular/http';
import { User } from '../models/index';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: Http) { }

  createUser(user: User) {
     return this.http.post('http://localhost:8080/user/users', user);
  }

  getAllUsers() {
    return this.http.get('http://localhost:8080/user/users').map((response: Response) => response.json());
  }

}
