import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicviewComponent } from './mechanicview.component';

describe('MechanicviewComponent', () => {
  let component: MechanicviewComponent;
  let fixture: ComponentFixture<MechanicviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MechanicviewComponent]
    });
    fixture = TestBed.createComponent(MechanicviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
