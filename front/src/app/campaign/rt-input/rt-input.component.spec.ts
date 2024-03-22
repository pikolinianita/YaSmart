import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RtInputComponent } from './rt-input.component';

describe('RtInputComponent', () => {
  let component: RtInputComponent;
  let fixture: ComponentFixture<RtInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RtInputComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RtInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
