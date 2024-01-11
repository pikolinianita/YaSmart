import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GarbageComponent } from './garbage.component';

describe('GarbageComponent', () => {
  let component: GarbageComponent;
  let fixture: ComponentFixture<GarbageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GarbageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GarbageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
