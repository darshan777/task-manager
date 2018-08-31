import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute  } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { UserIssueService } from '../Service/user-issue.service';
import { Issue } from '../models/index';

@Component({
  selector: 'app-update-issue',
  templateUrl: './update-issue.component.html',
  styleUrls: ['./update-issue.component.css']
})
export class UpdateIssueComponent implements OnInit {
  issueId;
  issue: Issue;
  constructor(private router: Router, private route: ActivatedRoute, private userIssueService: UserIssueService ) { }

  ngOnInit() {

    this.issueId = this.route.snapshot.paramMap.get('id');
    let IssueId = Number(this.issueId);
    this.getIssue(IssueId);
  }

  getIssue(issueId: number) {
    this.userIssueService.getSpecificIssues(issueId).subscribe(
      (Response) => { this.issue = Response;  console.log(this.issue); }
    );
  }

  onSubmit() {
      
  }

}


