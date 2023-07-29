import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../service/customer.service';
import { ActivatedRoute } from '@angular/router';

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

  constructor(private customerService: CustomerService, private fb: FormBuilder, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(query => {
      this.url = query['token'];
    })
    this.resetForm = this.fb.group({
      token: ['', Validators.required],
      newpassword: ['', [Validators.required, Validators.pattern('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$')]],
      confirmpassword: ['', Validators.required]
    }, {
      Validators: this.Missmatch('newpassword', 'confirmpassword')
    });

  }

  reset() {


    if (this.resetForm.invalid) {
      console.log("Reset password failed" + this.resetForm);
      this.errorMessage = "Reset password failed";
    }

    this.resetForm.patchValue({
      token: this.url
    })
    const resetData = this.resetForm.value
    console.log(resetData);

    this.customerService.resetPassword(this.resetForm.value).subscribe((response) => {
      console.log("Passwors reset Successful" + response);
      this.successMessage = "Password Changed Successfully";
    });
  }

  Missmatch(newpassword: any, confirmpassword: any) {
    return (formGroup: FormGroup) => {
      const newPasswordControl = formGroup.controls[newpassword];
      const confirmNewPasswordControl = formGroup.controls[confirmpassword];

      if (confirmNewPasswordControl.errors && !confirmNewPasswordControl.errors['Mismatch']) {
        return;
      }
      if (newPasswordControl.value !== confirmNewPasswordControl.value) {
        confirmNewPasswordControl.setErrors({ Mismatch: true })
      } else {
        confirmNewPasswordControl.setErrors(null);
      }
    }
  }

  passwordVisibility() {
    this.showPassword = !this.showPassword;
  }

}
