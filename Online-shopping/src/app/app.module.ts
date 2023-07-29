import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpComponent } from './shopping/sign-up/sign-up.component';
import { DesignerLoginComponent } from './designer-login/designer-login.component';



@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    DesignerLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
