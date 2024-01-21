import { Component, Input } from '@angular/core';
import { Icon } from '../../domain/icon';

@Component({
  selector: 'app-icon',
  standalone: true,
  imports: [],
  templateUrl: './icon.component.html',
  styleUrl: './icon.component.css'
})
 
export class IconComponent {

  @Input()
  public icon?: Icon;
  public edit = false;
  constructor() {}

  toggleEdit(){
    this.edit = !this.edit;
  }

}
