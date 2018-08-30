import { Component, OnInit } from '@angular/core';
import { User, Issue } from '../models/index';
import {UserIssueService } from '../Service/user-issue.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userissue',
  templateUrl: './userissue.component.html',
  styleUrls: ['./userissue.component.css']
})
export class UserissueComponent implements OnInit {
  currentUser: User;
  issues: Issue[];

  constructor(private userIssueService: UserIssueService, private router: Router) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    console.log('init initiated');
    this.getAllIssues();
  }

  getAllIssues() {
    console.log('get All Issues Method called');
      this.userIssueService.getAllIssues(this.currentUser.userId).subscribe(
        (Response) => { this.issues = Response; console.log(this.issues); }
      );
  }

  updateIssue(issueId: number) {
    console.log(issueId);
    this.router.navigate(['sidemenu/updateIssue', issueId]);
  }

}

