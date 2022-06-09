import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IleComponent } from './ile.component';

describe('IleComponent', () => {
  let component: IleComponent;
  let fixture: ComponentFixture<IleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
