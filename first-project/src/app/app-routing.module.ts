import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './designer-signup/sign-up.component';
import { IndexComponent } from './index/index.component';
import { LoginComponent } from './designer-login/login.component';
import { NavbarComponent } from './navbar/navbar.component';

const routes: Routes = [
  {path:'', redirectTo:'login', pathMatch:'full'},
  {path:'navbar', component:NavbarComponent},
  {path:'index', component:IndexComponent},
  {path:'sign-up', component:SignUpComponent},
  {path:'login', component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
