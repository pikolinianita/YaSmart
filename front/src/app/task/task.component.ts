import { Component } from '@angular/core';
import { IconComponent } from "../icon/icon.component";
import { Icon } from '../domain/icon';

@Component({
    selector: 'app-task',
    standalone: true,
    templateUrl: './task.component.html',
    styleUrl: './task.component.css',
    imports: [IconComponent]
})
export class TaskComponent {

  public label = "Thing to do";
  public check = false;
  public timer = new Icon("aa-bb-icon", 15, "timer", "red");
  public reward = new Icon("aa-bb-icon", 25, "monetization_on", "gold");
  public reward2 = new Icon("aa-bb-icon", 1, "local_pizza","brown");
}
