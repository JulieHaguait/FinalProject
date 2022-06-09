import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChapeauComponent } from './chapeau.component';

describe('ChapeauComponent', () => {
  let component: ChapeauComponent;
  let fixture: ComponentFixture<ChapeauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChapeauComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChapeauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
