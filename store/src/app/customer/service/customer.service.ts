import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {


  private signupUrl = 'http://localhost:8080/Subscriber/signup';

  private loginUrl = 'http://localhost:8080/Subscriber/signin';

  private resetUrl = 'http://localhost:8080/Subscriber/resetPassword';

  constructor(private http: HttpClient) { }

  signup(signupData: any): Observable<any> {
    return this.http.post(this.signupUrl, signupData);
  }

  login(loginData: any): Observable<any> {
    return this.http.post(this.loginUrl, loginData);
  }

  resetPassword(emailData: any): Observable<any> {
    return this.http.post(this.resetUrl, emailData);
  }


}
