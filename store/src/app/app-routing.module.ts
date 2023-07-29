import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PopupFormComponent } from './popup-form/popup-form.component';
import { SignupComponent } from './customer/signup/signup.component';
import { LoginComponent } from './customer/login/login.component';
import { HomeComponent } from './home/home.component';
import { ForgotPasswordComponent } from './customer/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './customer/reset-password/reset-password.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'home', component:HomeComponent},
  {path:'popup', component:PopupFormComponent},
  {path:'signup', component:SignupComponent},
  {path:'login', component:LoginComponent},
  {path:'forgot', component:ForgotPasswordComponent},
  {path:'resetPassword', component:ResetPasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
