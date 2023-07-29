import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder, FormControl, ValidationErrors, ValidatorFn, } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from '../service/api.service';


@Component({
  selector: 'app-designer-signup',
  templateUrl: './designer-signup.component.html',
  styleUrls: ['./designer-signup.component.scss']
})
export class DesignerSignupComponent implements OnInit {

  signupForm: FormGroup | any
  myControl: FormControl | any
  signupData: any
  submitted = false;
  email: string | any




  constructor(private fb: FormBuilder, private apiService: ApiService, private router: Router) {

  }

  ngOnInit(): void {
    this.signupForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(4)]],
      email: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}')]],
      password: ['', [Validators.required, Validators.pattern('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$')]],
      confirmpassword: ['', Validators.required],
      mobile: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      addressline1: ['', Validators.required],
      addressline2: ['', Validators.required],
      landmark: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
      country: ['', Validators.required],
      pincode: ['', [Validators.required, Validators.pattern('^[0-9]{6}$')]]
    }, {
      validators: this.Missmatch('password', 'confirmpassword')
    });
  }

  // signupForm = new FormGroup({
  //   name: new FormControl("", Validators.required),
  // })

  signup() {
    this.submitted = true;



    if (this.signupForm.invalid) {
      console.log("signUp failed" + this.signupForm);
    }

    const signupData = this.signupForm.value;
    console.log(signupData)
    console.log(this.signupForm.controls.email.value)
    this.apiService.signup(signupData).subscribe((response) => {
      // console.log(this.signupForm.valid);
      console.log("Signup successful" + response);

      this.router.navigate(['/otp-verify', this.signupForm.controls.email.value]);
    });
  }

  Missmatch(password: any, confirmpassword: any) {
    return (formGroup: FormGroup) => {
      const passwordControl = formGroup.controls[password];
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
}


