import { TestBed } from '@angular/core/testing';

import { NodeRefService } from './node-ref.service';

describe('NodeRefService', () => {
  let service: NodeRefService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NodeRefService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
