import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { PopupFormComponent } from '../popup-form/popup-form.component';
import { SubscribeService } from '../service/subscribe.service';
import { NgToastService } from 'ng-angular-popup';
import { LoginComponent } from '../customer/login/login.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  title: any
  successMessage: any

  successMess = false;

  constructor(private dialog: MatDialog, private subscribeService: SubscribeService) { }

  ngOnInit(): void {
    setTimeout(() => {
      this.openPopupFormPopup()
    }, 2000);
  }

  openLogin(){
    const dialogRef: MatDialogRef<LoginComponent> = this.dialog.open(LoginComponent,{

    });
  }

  openPopupFormPopup() {
    const dialogRef: MatDialogRef<PopupFormComponent> = this.dialog.open(PopupFormComponent, {
      // width: '350px',
      // height: '450px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog closed');
    });

  }
}
