import { Component, Input } from '@angular/core';
import { Icon } from '../../domain/icon';

@Component({
  selector: 'app-icon-editable',
  standalone: true,
  imports: [],
  templateUrl: './icon-editable.component.html',
  styleUrl: './icon-editable.component.css'
})
export class IconEditableComponent {
  
  @Input()
  public icon?: Icon;
  public edit = false;
  constructor() {}

  toggleEdit(){
    this.edit = !this.edit;
  }

}
