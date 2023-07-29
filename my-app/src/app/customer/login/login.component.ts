import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup | any
  myControl: FormControl | any
  loginData: any
  errorMessage: any

  password:string |any
  showPassword: boolean = false;

  constructor(private customerService: CustomerService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: new FormControl("", [Validators.required]),
      password: new FormControl("", [Validators.required])
    });
  }

  login() {

    if (this.loginForm.invalid) {
      console.log("Invalid email or password" + this.loginForm);
      this.errorMessage = "Invalid email or password";
    }

    const loginData = this.loginForm.value;
    this.customerService.login(loginData).subscribe((response) => {
      console.log("Login Successful" + response);
    });
  }

  passwordVisibility(){
    this.showPassword = !this.showPassword;
  }

}
