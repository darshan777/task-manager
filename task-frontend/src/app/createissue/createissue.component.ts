import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { User, Issue } from '../models/index';
import {UserIssueService } from '../Service/user-issue.service';

@Component({
  selector: 'app-createissue',
  templateUrl: './createissue.component.html',
  styleUrls: ['./createissue.component.css']
})
export class CreateissueComponent implements OnInit {
  CreateIssue: FormGroup;
  issue: Issue;
  currentUser: User;

  constructor(private userIssueService: UserIssueService) { }

  ngOnInit() {
    this.CreateIssue = new FormGroup({
        'issueName': new FormControl(''),
        'issueDescription': new FormControl(''),
        'Priority': new FormControl('Low'),
        'issueStatus': new FormControl('New')

    });
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  onSubmit() {
    console.log(this.CreateIssue.value.Priority);
    this.userIssueService.createIssue(this.CreateIssue.value)
    .subscribe(
      (Response) => console.log(Response),
      (Error) => console.log(Error)
    );
  }

}

