import { Injectable } from '@angular/core';
import { Http, Response, Headers  } from '@angular/http';
import { User, Issue } from '../models/index';

@Injectable({
  providedIn: 'root'
})
export class UserIssueService {
  currentUser: User;
  constructor(private http: Http) { }

  createIssue(issue: Issue) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    let userid = this.currentUser.userId;
    return this.http.post('http://localhost:8080/issue/issues/' + userid, issue);
 }

 getAllIssues(userId: number) {
  console.log('Reached Issue Service ' + userId);
   return this.http.get('http://localhost:8080/issue/issues/' + userId ).map((response: Response) => response.json());
 }

 getSpecificIssues(issueid: number) {
  return this.http.get('http://localhost:8080/issue/issues/specificIssue/' + issueid ).map((response: Response) => response.json());
 }
}
