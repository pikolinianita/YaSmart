import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IconEditableComponent } from './icon-editable.component';

describe('IconEditableComponent', () => {
  let component: IconEditableComponent;
  let fixture: ComponentFixture<IconEditableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IconEditableComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IconEditableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
