import { TestBed } from '@angular/core/testing';

import { Skykid.Service } from './skykid.service.service';

describe('Skykid.ServiceService', () => {
  let service: SkykidService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Skykid.ServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
