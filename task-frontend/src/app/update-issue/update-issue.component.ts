import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute  } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-update-issue',
  templateUrl: './update-issue.component.html',
  styleUrls: ['./update-issue.component.css']
})
export class UpdateIssueComponent implements OnInit {
  issueId;
  constructor(private router: Router, private route: ActivatedRoute ) { }

  ngOnInit() {

    this.issueId = this.route.snapshot.paramMap.get('id');
  }

}


