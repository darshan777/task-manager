import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { User } from '../models/index';
import { UserServiceService } from '../Service/user-service.service';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';
import {
  AuthService,
  SocialUser,
  FacebookLoginProvider,
  GoogleLoginProvider
} from 'angular5-social-login';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  CreateUser: FormGroup;
  user: User;
  users: User[];
  private socialuser: SocialUser;
  public authorized = false;

  constructor(private userService: UserServiceService, private socialAuthService: AuthService) { }

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

public socialSignIn(socialPlatform: string) {
  let socialPlatformProvider;
  if (socialPlatform === 'facebook') {
    socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
  } else if (socialPlatform === 'google') {
    socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
  }

  this.socialAuthService.signIn(socialPlatformProvider).then(
    (userData) => {
      console.log(socialPlatform + ' sign in data : ' , userData);
      alert(socialPlatform + ' sign in data : ' + userData);
      // Now sign-in with userData
      if (userData != null) {
             this.authorized = true;
             this.socialuser = userData;
          }
    }
  );
}


}

