import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { DesignerLoginComponent } from './designer-login/designer-login.component';
import { SignupComponent } from './customer/signup/signup.component';
import { LoginComponent } from './customer/login/login.component';
import { HomeComponent } from './customer/home/home.component';
import { DesignerSignupComponent } from './designer-signup/designer-signup.component';
import { OtpVerifyComponent } from './otp-verify/otp-verify.component';
import { IndexComponent } from './index/index.component';
import { ForgotPasswordComponent } from './customer/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './customer/reset-password/reset-password.component';

@NgModule({
  declarations: [
    AppComponent,
    DesignerSignupComponent,
    DesignerLoginComponent,
    OtpVerifyComponent,
    IndexComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    ForgotPasswordComponent,
    ResetPasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
