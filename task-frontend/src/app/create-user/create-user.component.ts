import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { User } from '../models/index';
import { UserServiceService } from '../Service/user-service.service';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  CreateUser: FormGroup;
  user: User;
  users: User[];
  constructor(private userService: UserServiceService) { }

  ngOnInit() {
    this.CreateUser = new FormGroup({
      'userName': new FormControl(''),
      'userPassword': new FormControl(''),
      'userEmail': new FormControl(''),
    });
    this.getAllUsers();
  }
  onSubmit() {
    console.log(this.CreateUser.value);
    this.userService.createUser(this.CreateUser.value)
    .subscribe(
      (Response) => console.log(Response),
      (Error) => console.log(Error)
    );
  }
getAllUsers() {
  this.userService.getAllUsers().subscribe(
    (response) => { this.users =  response; console.log(this.users); }
  );
}

}

