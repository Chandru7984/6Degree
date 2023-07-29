import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  postData(signupData: any){
  }
  private signupUrl = 'http://localhost:8080/register';

  private loginUrl = 'http://localhost:8080/signin';

  private otpUrl = 'http://localhost:8080/verify-account';

  // private resendUrl = 'http://localhost:8080/regenerate-otp';


  constructor(private http: HttpClient) {}

  signup(signupData: any): Observable<any> {
    return this.http.post(this.signupUrl, signupData);
  }


  login(loginData:any): Observable<any>{
      return this.http.post(this.loginUrl,loginData);
  }

  verifyOtp(email:string, otp:string){
    return this.http.put(this.otpUrl,{email,otp});
  }
}


