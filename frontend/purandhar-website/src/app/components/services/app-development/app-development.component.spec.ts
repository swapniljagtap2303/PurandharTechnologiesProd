import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppDevelopmentComponent } from './app-development.component';

describe('AppDevelopmentComponent', () => {
  let component: AppDevelopmentComponent;
  let fixture: ComponentFixture<AppDevelopmentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AppDevelopmentComponent]
    });
    fixture = TestBed.createComponent(AppDevelopmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
