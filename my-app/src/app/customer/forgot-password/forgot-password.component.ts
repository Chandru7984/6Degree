import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../service/customer.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent implements OnInit{

  forgotForm: FormGroup | any
  email: string | any
  errorMessage: any
  successMessage: any
  FormControl: any


  constructor(private http: HttpClient, private router: Router, private fb : FormBuilder) {

  }
  ngOnInit(): void {

    // this.email
  
    this.forgotForm = this.fb.group({
    email:['',[Validators.required, Validators.pattern('[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}')]]
  });
  }

  sendLink() {

    const sendUrl = 'http://localhost:8080/customer/forgot_password';

    if(this.forgotForm.invalid){
      console.log("Invalid mail or failed to send link");
    }
    // const request = {
    //   email: this.forgotForm.controls.email.value
    // }
    const request = this.forgotForm.value
    this.http.post(sendUrl, request).subscribe((response )=> {
      console.log("Password reset link sent Successfully" + response);
    });
  }

}
