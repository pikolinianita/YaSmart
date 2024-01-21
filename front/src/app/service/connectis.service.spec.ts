import { TestBed } from '@angular/core/testing';

import { ConnectisService } from './connectis.service';

describe('ConnectisService', () => {
  let service: ConnectisService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConnectisService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
