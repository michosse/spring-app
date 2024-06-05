import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechaniceditComponent } from './mechanicedit.component';

describe('MechaniceditComponent', () => {
  let component: MechaniceditComponent;
  let fixture: ComponentFixture<MechaniceditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MechaniceditComponent]
    });
    fixture = TestBed.createComponent(MechaniceditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
