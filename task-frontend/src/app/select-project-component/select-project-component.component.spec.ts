import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectProjectComponentComponent } from './select-project-component.component';

describe('SelectProjectComponentComponent', () => {
  let component: SelectProjectComponentComponent;
  let fixture: ComponentFixture<SelectProjectComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectProjectComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectProjectComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
