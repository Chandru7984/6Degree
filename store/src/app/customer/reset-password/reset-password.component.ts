import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../service/customer.service';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.scss']
})
export class ResetPasswordComponent implements OnInit {

  url: any
  resetForm: FormGroup | any
  showPassword: boolean = false;
  newpassword: any;
  confirmnewpassword: any;
  errorMessage: any;
  successMessage: any;

  constructor(private customerService: CustomerService, private fb: FormBuilder, private route: ActivatedRoute, private toast: NgToastService,
    private router: Router) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(query => {
      this.url = query['token'];
    })
    this.resetForm = this.fb.group({
      token: ['', Validators.required],
      newpassword: ['', [Validators.required, Validators.pattern('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$')]],
      confirmpassword: ['', Validators.required]
    }, {
      validators: this.Missmatch('newpassword', 'confirmpassword')
    });

  }

  reset() {

    if (this.resetForm.invalid) {
      console.log("Reset password failed" + this.resetForm);

      this.toast.error({ detail: "Error Message", summary: "Reset Password failed!", duration: 4000, position: 'topRight' });
    }

    this.resetForm.patchValue({
      token: this.url
    })
    const resetData = this.resetForm.value
    console.log(resetData);

    this.customerService.resetPassword(this.resetForm.value).subscribe((response) => {
      console.log("Passwors reset Successful" + response);

      // this.successMessage = "Password Changed Successfully and you can login";

      this.toast.success({ detail: "Success Message", summary: "Password Change Successful, you can login!", duration: 5000, position: 'topRight' });

      this.resetForm.reset();

      // this.router.navigate(["/login"]);
      return;
    });
  }

  Missmatch(newpassword: any, confirmpassword: any) {
    return (formGroup: FormGroup) => {
      const passwordControl = formGroup.controls[newpassword];
      const confirmPasswordControl = formGroup.controls[confirmpassword];

      if (confirmPasswordControl.errors && !confirmPasswordControl.errors['Mismatch']) {
        return;
      }
      if (passwordControl.value !== confirmPasswordControl.value) {
        confirmPasswordControl.setErrors({ Mismatch: true })
      } else {
        confirmPasswordControl.setErrors(null);
      }
    }
  }

  passwordVisibility() {
    this.showPassword = !this.showPassword;
  }

}
