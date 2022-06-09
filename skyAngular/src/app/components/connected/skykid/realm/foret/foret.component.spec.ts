import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForetComponent } from './foret.component';

describe('ForetComponent', () => {
  let component: ForetComponent;
  let fixture: ComponentFixture<ForetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ForetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ForetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
