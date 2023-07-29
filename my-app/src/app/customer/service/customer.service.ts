import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  // postData(signupData:any){

  // }
  private signupUrl = 'http://localhost:8080/Customer/signup';

  private loginUrl = 'http://localhost:8080/Customer/signin';

  private resetUrl = 'http://localhost:8080/customer/resetPassword';

  constructor(private http:HttpClient) { }

  signup(signupData:any):Observable<any>{
    return this.http.post(this.signupUrl,signupData);
  }

  login(loginData:any): Observable<any>{
    return this.http.post(this.loginUrl,loginData);
  }

  resetPassword(emailData:any): Observable<any>{
    return this.http.post(this.resetUrl,emailData);
  }
}
