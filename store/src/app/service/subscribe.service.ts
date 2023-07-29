import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubscribeService {

  private subscribeUrl = 'http://localhost:8080/subscribe';

  // private successMessageSource = new Subject<string>();
  // successMessage$ = this.successMessageSource.asObservable();

  // sendSuccessMessage(message:string){
  //   this.successMessageSource.next(message);
  // }

  constructor(private http: HttpClient) { }

  subscribeEmail(formData: any): Observable<any> {
    return this.http.post(this.subscribeUrl,formData);
  }
}