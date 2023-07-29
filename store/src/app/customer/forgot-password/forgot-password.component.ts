import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent implements OnInit{

  forgotForm: FormGroup | any
  email: string | any
  errorMessage: any
  successMessage: string | any
  FormControl: any


  constructor(private http: HttpClient, private router: Router, private fb : FormBuilder,private toast: NgToastService) {

  }
  ngOnInit(): void {

    // this.email
  
    this.forgotForm = this.fb.group({
    email:['',[Validators.required, Validators.pattern('[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}')]]
  });
  }

  showToast(){
    this.toast.error({ detail: "Error Message", summary: "Invalid email", duration: 4000, position:'topRight'});
  }

  sendLink() {

    const sendUrl = 'http://localhost:8080/Subscriber/forgot_password';

    setTimeout(() => {
      this.errorMessage = "";
    }, 3000);

    if(this.forgotForm.invalid){
      console.log("Invalid mail or failed to send link");
      this.errorMessage = "Invalid email";

      this.toast.error({ detail: "Error Message", summary: "Failed to send link, please try again", duration: 4000, position:'topRight'});

      return;
    }

    // const request = {
    //   email: this.forgotForm.controls.email.value
    // }
    const request = this.forgotForm.value
    this.http.post(sendUrl, request).subscribe((response )=> {
      console.log("Password reset link sent Successfully" + response);

      this.toast.success({ detail: "Email Sent", summary: "Check your email and change the password there", duration: 4000, position:'topRight'});

      return;
    });
  }

}
