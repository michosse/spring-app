import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicaddComponent } from './mechanicadd.component';

describe('MechanicaddComponent', () => {
  let component: MechanicaddComponent;
  let fixture: ComponentFixture<MechanicaddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MechanicaddComponent]
    });
    fixture = TestBed.createComponent(MechanicaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
