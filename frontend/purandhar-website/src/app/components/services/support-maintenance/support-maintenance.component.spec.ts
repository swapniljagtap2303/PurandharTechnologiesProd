import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupportMaintenanceComponent } from './support-maintenance.component';

describe('SupportMaintenanceComponent', () => {
  let component: SupportMaintenanceComponent;
  let fixture: ComponentFixture<SupportMaintenanceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SupportMaintenanceComponent]
    });
    fixture = TestBed.createComponent(SupportMaintenanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
