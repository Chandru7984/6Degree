import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PopupFormComponent } from './popup-form/popup-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { SignupComponent } from './customer/signup/signup.component';
import { LoginComponent } from './customer/login/login.component';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { HomeComponent } from './home/home.component';
import { NgToastModule } from 'ng-angular-popup';
import { ForgotPasswordComponent } from './customer/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './customer/reset-password/reset-password.component';
// import { ToastrModule } from 'ngx-toastr';





@NgModule({
  declarations: [
    AppComponent,
    PopupFormComponent,
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
    HttpClientModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    NgToastModule
  ],
  providers: [],
  bootstrap: [AppComponent]
  // schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
