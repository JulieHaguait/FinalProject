import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoiffeComponent } from './coiffe.component';

describe('CoiffeComponent', () => {
  let component: CoiffeComponent;
  let fixture: ComponentFixture<CoiffeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoiffeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoiffeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
