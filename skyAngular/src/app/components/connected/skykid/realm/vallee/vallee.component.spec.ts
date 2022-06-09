import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValleeComponent } from './vallee.component';

describe('ValleeComponent', () => {
  let component: ValleeComponent;
  let fixture: ComponentFixture<ValleeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValleeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ValleeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
