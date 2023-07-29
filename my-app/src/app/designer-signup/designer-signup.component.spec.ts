import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesignerSignupComponent } from './designer-signup.component';

describe('DesignerSignupComponent', () => {
  let component: DesignerSignupComponent;
  let fixture: ComponentFixture<DesignerSignupComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DesignerSignupComponent]
    });
    fixture = TestBed.createComponent(DesignerSignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
