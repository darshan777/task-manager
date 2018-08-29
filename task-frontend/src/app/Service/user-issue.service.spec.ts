import { TestBed, inject } from '@angular/core/testing';

import { UserIssueService } from './user-issue.service';

describe('UserIssueService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserIssueService]
    });
  });

  it('should be created', inject([UserIssueService], (service: UserIssueService) => {
    expect(service).toBeTruthy();
  }));
});
