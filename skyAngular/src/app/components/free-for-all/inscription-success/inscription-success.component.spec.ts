import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionSuccessComponent } from './inscription-success.component';

describe('InscriptionSuccessComponent', () => {
  let component: InscriptionSuccessComponent;
  let fixture: ComponentFixture<InscriptionSuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionSuccessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
