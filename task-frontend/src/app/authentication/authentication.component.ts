import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { User } from '../models/index';
import { UserServiceService } from '../Service/user-service.service';
import {Observable} from 'rxjs/Observable';
import { Router } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {
  users: User[];
  user: User;
  authenticateUser: FormGroup;
  returnUrl: string;
  currentUser: User;
  counter: boolean;

  constructor(private userService: UserServiceService, private router: Router) { }

  ngOnInit() {
    this.authenticateUser = new FormGroup({
      'userName': new FormControl(''),
      'userPassword': new FormControl('')
    });
    this.getAllUsers();
    

  }
  getAllUsers() {
    this.userService.getAllUsers().subscribe(
      (response) => { this.users =  response;  }
    );
  }


  onSubmit() {
  let name = this.authenticateUser.value.userName;
  let password = this.authenticateUser.value.userPassword;
  let counterr = 'false';
    console.log(typeof(name));
    this.users.forEach(function(user) {
       if (user.userName === name) {
          if (user.userPassword === password) {
              console.log(name);
              localStorage.setItem('currentUser', JSON.stringify(user));
              counterr = 'true';
          }
       }
    });
    if (counterr === 'true') {
      this.router.navigate(['/sidemenu']);
    }
  }

  test() {
    this.router.navigate(['/sidemenu']);
  }

}
