import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DesignerLoginComponent } from './designer-login/designer-login.component';


import { SignupComponent } from './customer/signup/signup.component';
import { LoginComponent } from './customer/login/login.component';
import { DesignerSignupComponent } from './designer-signup/designer-signup.component';
import { IndexComponent } from './index/index.component';
import { OtpVerifyComponent } from './otp-verify/otp-verify.component';
import { HomeComponent } from './customer/home/home.component';
import { ForgotPasswordComponent } from './customer/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './customer/reset-password/reset-password.component';


const routes: Routes = [
  {path: '', component:IndexComponent},
  {path: 'signup', component:DesignerSignupComponent},
  {path: 'login', component:DesignerLoginComponent},
  {path: 'otp-verify/:email', component:OtpVerifyComponent},
  {path: 'index', component:IndexComponent},
  {path: 'customerSignup', component:SignupComponent},
  {path: 'customerLogin', component:LoginComponent},
  {path: 'customerHome', component:HomeComponent},
  {path: 'forgotPassword', component:ForgotPasswordComponent},
  {path: 'resetPassword', component:ResetPasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [DesignerLoginComponent]
