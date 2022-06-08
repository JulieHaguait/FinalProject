import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilSkykidComponent } from './profil-skykid.component';

describe('ProfilSkykidComponent', () => {
  let component: ProfilSkykidComponent;
  let fixture: ComponentFixture<ProfilSkykidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfilSkykidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilSkykidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
