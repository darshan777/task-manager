import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserissueComponent } from './userissue.component';

describe('UserissueComponent', () => {
  let component: UserissueComponent;
  let fixture: ComponentFixture<UserissueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserissueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserissueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
