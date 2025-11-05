import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CloudSolutionsComponent } from './cloud-solutions.component';

describe('CloudSolutionsComponent', () => {
  let component: CloudSolutionsComponent;
  let fixture: ComponentFixture<CloudSolutionsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CloudSolutionsComponent]
    });
    fixture = TestBed.createComponent(CloudSolutionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
