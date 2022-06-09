import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSkykidComponent } from './list-skykid.component';

describe('ListSkykidComponent', () => {
  let component: ListSkykidComponent;
  let fixture: ComponentFixture<ListSkykidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListSkykidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSkykidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
