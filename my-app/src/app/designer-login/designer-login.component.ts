
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from '../service/api.service';


@Component({
  selector: 'app-designer-login',
  templateUrl: './designer-login.component.html',
  styleUrls: ['./designer-login.component.scss']
})
export class DesignerLoginComponent implements OnInit {

  loginForm: FormGroup | any
  myControl: FormControl | any
  loginData: any
  errorMessage: any

  password:string |any
  showPassword: boolean = false;

  constructor(private apiService: ApiService, private fb: FormBuilder, private router: Router) {

  }
  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: new FormControl("", [Validators.required]),
      password: new FormControl("", [Validators.required])
    });


  }

  login() {

    if (this.loginForm.invalid) {
      console.log("Invalid email or Password" + this.loginForm);
      this.errorMessage = "Invalid email or password";

    }
    const loginData = this.loginForm.value;
    this.apiService.login(loginData).subscribe((response) => {
      console.log("Login Successful" + response);
      this.router.navigate(['/index'])
    });
  }

  passwordVisibility(){
    this.showPassword = !this.showPassword;
  }

}
