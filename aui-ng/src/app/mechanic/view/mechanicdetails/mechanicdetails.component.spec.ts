import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicdetailsComponent } from './mechanicdetails.component';

describe('MechanicdetailsComponent', () => {
  let component: MechanicdetailsComponent;
  let fixture: ComponentFixture<MechanicdetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MechanicdetailsComponent]
    });
    fixture = TestBed.createComponent(MechanicdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
