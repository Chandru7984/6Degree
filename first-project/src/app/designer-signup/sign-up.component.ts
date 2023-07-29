import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

  name: string="";
  email:string="";
  password:string="";
  confirmpassword:string="";
  mobile:string="";
  addressline1:string="";
  addressline2:string="";
  landmark:string="";
  city:string="";
  state:string="";
  country:string="";
  pincode:string="";
}

constructor(private http: HttpClient){
  
}
