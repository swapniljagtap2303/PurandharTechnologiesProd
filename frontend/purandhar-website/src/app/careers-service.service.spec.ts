import { TestBed } from '@angular/core/testing';

import { CareersServiceService } from './service/careers-service.service';

describe('CareersServiceService', () => {
  let service: CareersServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CareersServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
