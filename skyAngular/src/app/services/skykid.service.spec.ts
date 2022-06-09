import { TestBed } from '@angular/core/testing';

import { SkykidService } from './skykid.service';

describe('SkykidService', () => {
  let service: SkykidService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkykidService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
