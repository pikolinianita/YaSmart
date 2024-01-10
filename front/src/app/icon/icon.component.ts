import { Component, Injectable, Input } from '@angular/core';
import { Icon } from '../domain/icon';

@Component({
  selector: 'app-icon',
  standalone: true,
  imports: [],
  templateUrl: './icon.component.html',
  styleUrl: './icon.component.css'
})
 
export class IconComponent {

  @Input()
  public icon?: Icon;// = new Icon("aa-bb-icon", 10, "timer", "red");

 //public icon:string = "aaa";

  constructor() {
  
    console.log("oto icon" );
  }

}
