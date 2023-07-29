import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-otp-verify',
  templateUrl: './otp-verify.component.html',
  styleUrls: ['./otp-verify.component.scss']
})
export class OtpVerifyComponent implements OnInit {

  email: string | any
  otp: string | any

  constructor(private http: HttpClient, private activatedRoute: ActivatedRoute, private router: Router) {

  }
  ngOnInit() {
    this.email = this.activatedRoute.snapshot.paramMap.get('email')
  }

  verifyOtp() {
    const verificationData = {
      email: this.email,
      otp: this.otp
    };



    this.http.put('http://localhost:8080/verify-account?email=' + this.email + '&otp=' + this.otp, {}).subscribe(response => {
      console.log(response);

      console.log('OTP verification successful');
      this.router.navigate(['login'])
    },
      error => {
        console.log('OTP verification failed');
      }
    )
  }



}
