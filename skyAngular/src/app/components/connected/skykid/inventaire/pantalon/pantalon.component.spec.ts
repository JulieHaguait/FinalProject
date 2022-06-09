import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PantalonComponent } from './pantalon.component';

describe('PantalonComponent', () => {
  let component: PantalonComponent;
  let fixture: ComponentFixture<PantalonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PantalonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PantalonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
