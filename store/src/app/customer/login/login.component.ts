import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { CustomerService } from '../service/customer.service';
import { NgToastService } from 'ng-angular-popup';
import { Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginForm: FormGroup | any
  myControl: FormControl | any
  loginData: any

  email: any
  password: any

  errorMessage: any
  showPassword: any
  passwordMes: any
  mailError: any

  constructor(private customerService: CustomerService, private fb: FormBuilder, private toast: NgToastService,
    private router: Router, private dialogRef: MatDialogRef<LoginComponent>) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  login() {

    setTimeout(() => {
      this.errorMessage = "";
    }, 4000);

    // setTimeout(() => {
    //   this.mailError = "";
    // }, 4000);

    if (this.loginForm.invalid || this.loginForm == null) {
      console.log("Invalid email or password" + this.loginForm);

      this.toast.error({ detail: "Error Message", summary: "Please enter valid Credentials!", duration: 4000, position: 'topRight' });

      // this.errorMessage = "Please enter valid Credentials";

      return;
    }

    if (this.email == null) {
      this.errorMessage = "Invalid email or password";
    }

    const loginData = this.loginForm.value;
    this.customerService.login(loginData).subscribe((response) => {
      console.log("Login Successful" + response);
      this.toast.success({ detail: "Success Message", summary: "Login Successful!", duration: 4000, position: 'topRight' });

      // this.router.navigate(["home"]);

      this.dialogRef.close();

      return;
    });
  }

  passwordVisibility() {
    this.showPassword = !this.showPassword;
  }

  closeLogin(){
    this.dialogRef.close();
  }

}
