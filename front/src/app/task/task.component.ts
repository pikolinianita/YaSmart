import { Component, Input } from '@angular/core';
import { IconComponent } from "../icon/icon.component";
import { Icon } from '../domain/icon';
import { Task } from '../domain/task';

@Component({
    selector: 'app-task',
    standalone: true,
    templateUrl: './task.component.html',
    styleUrl: './task.component.css',
    imports: [IconComponent]
})
export class TaskComponent {

  @Input()
  public inner! : Task;

 // public label = "Thing to do";
 // public check = false;
 // public timer = this.inner?.time
 // public reward = this.inner?.reward;
  //public reward2 = new Icon("aa-bb-icon", 1, "local_pizza","brown");
}
