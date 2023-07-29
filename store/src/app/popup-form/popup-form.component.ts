import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { SubscribeService } from '../service/subscribe.service';
import { Router } from '@angular/router';
// import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDialogRef } from '@angular/material/dialog';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-popup-form',
  templateUrl: './popup-form.component.html',
  styleUrls: ['./popup-form.component.scss']
})
export class PopupFormComponent implements OnInit {

  subscribeForm: FormGroup | any

  showSuccessMesssage = false;

  errorMessage: any
  mailError: any

  data : any

  email : any

  @Output() closePopupForm = new EventEmitter<void>();
  // hideForm: any;

  constructor(public dialogRef: MatDialogRef<PopupFormComponent>, private fb: FormBuilder, private subscribeService: SubscribeService,
    private toast: NgToastService, private router: Router) { }

  ngOnInit(): void {
    // this.openMsg();

    this.subscribeForm = this.fb.group({
      fullname: new FormControl('', [Validators.required, Validators.minLength(3)]),
      email: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}')]),
      department: new FormControl('', [Validators.required])
    });

  }

  submitForm() {

    // if(this.subscribeForm==null){
    //   this.errorMessage = "Please enter valid email address";
    // }

    setTimeout(() => {
      this.errorMessage = "";
    }, 4000);

    setTimeout(() => {
      this.mailError = "";
    }, 4000);
  
    if (this.subscribeForm.invalid) {
      console.log("Subscription failed" + this.subscribeForm);
      this.errorMessage = "Please enter valid Credentials";

      this.toast.error({ detail: "Error Message", summary: "Subscription failed, please try again", duration: 4000, position: 'topRight' });

      return;
    }

    if(this.email == null){
      this.mailError = "Please enter valid email address"
    }

    const formData = this.subscribeForm.value;
    console.log(formData);
    this.subscribeService.subscribeEmail(formData).subscribe((response) => {
      console.log("Subscribe Successful" + response);

      this.subscribeForm.reset();

      this.toast.success({ detail: "Success Message", summary: "Subscription Successful!", duration: 4000, position: 'topRight' });

      this.dialogRef.close();

      return;
    });
  }

  closeDialog() {
    this.dialogRef.close();
  }
}
