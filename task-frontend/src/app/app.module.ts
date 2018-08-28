import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AuthenticationComponent } from './authentication/authentication.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SideMenuComponent } from './side-menu/side-menu.component';
import { HttpModule } from '@angular/http';
import { UserServiceService } from './Service/user-service.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import { Routes, RouterModule } from '@angular/router';
import {
  SocialLoginModule,
  AuthServiceConfig,
  GoogleLoginProvider,
  FacebookLoginProvider,
} from 'angular5-social-login';
import { UserissueComponent } from './userissue/userissue.component';
import { CreateissueComponent } from './createissue/createissue.component';

// Configs 
export function getAuthServiceConfigs() {
  let config = new AuthServiceConfig(
      [
       
        {
          id: GoogleLoginProvider.PROVIDER_ID,
	      provider: new GoogleLoginProvider('112882521231-nsjv8r7gi5aptr3evd8sihcmbqj0u5an.apps.googleusercontent.com')
        }
      ]
  );
  return config;
}

const appRoutes: Routes = [

{ path: '', component: AuthenticationComponent },
{ path: 'createUser', component: CreateUserComponent },
{ path: 'sidemenu', component: SideMenuComponent , children:[
  { path: 'userissue', component: UserissueComponent}
]}
];

@NgModule({
  declarations: [
    AppComponent,
    AuthenticationComponent,
    CreateUserComponent,
    HeaderComponent,
    FooterComponent,
    SideMenuComponent,
    DashboardComponent,
    UserissueComponent,
    CreateissueComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    SocialLoginModule
  ],
  providers: [
    UserServiceService,
    {
    provide: AuthServiceConfig,
    useFactory: getAuthServiceConfigs
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
