import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSkykidComponent } from './edit-skykid.component';

describe('EditSkykidComponent', () => {
  let component: EditSkykidComponent;
  let fixture: ComponentFixture<EditSkykidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditSkykidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditSkykidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
