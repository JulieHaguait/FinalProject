import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoeurComponent } from './coeur.component';

describe('CoeurComponent', () => {
  let component: CoeurComponent;
  let fixture: ComponentFixture<CoeurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoeurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoeurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
