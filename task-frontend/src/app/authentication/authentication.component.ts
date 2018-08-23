import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { User } from '../models/index';
import { UserServiceService } from '../Service/user-service.service';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {
  users: User[];
  user: User;
  authenticateUser: FormGroup;

  constructor(private userService: UserServiceService) { }

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
 /* onSubmit() {
    this.users.forEach(function(user) {
      console.log(user.userName);
      let name = this.authenticateUser.value.userName;
      console.log(this.authenticateUser.value.userName);
    });
  }*/

  onSubmit() {
  let name = this.authenticateUser.value.userName;
  let password = this.authenticateUser.value.userPassword;
    console.log(typeof(name));
    this.users.forEach(function(user) {
       if (user.userName === name) {
          if (user.userPassword === password){
              console.log(name);
          }
       }
    });
  }

}
