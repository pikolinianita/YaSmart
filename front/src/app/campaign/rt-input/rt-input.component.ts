import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RewardType } from '../../domain/reward-type';

@Component({
  selector: 'app-rt-input',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './rt-input.component.html',
  styleUrl: './rt-input.component.css'
})
export class RtInputComponent {
  profileForm = new FormGroup({
    nameX: new FormControl(''),
    iconName: new FormControl(''),
    colorHex: new FormControl(''),
  });

  @Output() saveEvent = new EventEmitter<RewardType>();

  createRT(): void {
    console.log(this.profileForm.value);
    let result = new RewardType(null, this.profileForm.value.nameX!, this.profileForm.value.iconName!, this.profileForm.value.colorHex!);
    this.saveEvent.emit(result);
  }

}
