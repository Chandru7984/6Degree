import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from '../service/customer.service';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {

  signupForm: FormGroup | any
  myControl: FormControl | any
  signupData: any
  submitted = false;
  email: string | any

  showPassword: boolean = false;

  constructor(private fb: FormBuilder, private customerService: CustomerService, private router: Router, private toast: NgToastService) {

  }

  ngOnInit(): void {
    this.signupForm = this.fb.group({
      fullname: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}')]],
      password: ['', [Validators.required, Validators.pattern('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$')]],
      confirmpassword: ['', Validators.required],
      mobile: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      name: ['', [Validators.required, Validators.minLength(4)]],
      addressline1: ['', Validators.required],
      addressline2: ['', Validators.required],
      landmark: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
      country: ['', Validators.required],
      pincode: ['', [Validators.required, Validators.pattern('^[0-9]{6}$')]],
      description: ['']
    }, {
      validators: this.Missmatch('password', 'confirmpassword')
    });
  }


  signup() {


    if (this.signupForm.invalid) {
      console.log("Signup failed" + this.signupForm);

      this.toast.error({ detail: "Error Message", summary: "Signup failed, please try again", duration: 4000, position:'topRight'});

      return;
    }

    const signupData = this.signupForm.value;
    this.customerService.signup(signupData).subscribe((response) => {
      console.log("Signup Successful" + response);

      this.toast.success({detail: "Succes Message", summary: "Signup Successful!", duration:4000, position:'topRight'});

      this.router.navigate(["/home"]);

      return;
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

  passwordVisibility() {
    this.showPassword = !this.showPassword;
  }

}
