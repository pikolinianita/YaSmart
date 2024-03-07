import { Component, Input } from '@angular/core';
import { IconComponent } from "../../common/icon/icon.component";
import { Task } from '../../domain/task';

@Component({
    selector: 'app-task',
    standalone: true,
    templateUrl: './task.component.html',
    styleUrl: './task.component.css',
    imports: [IconComponent]
})
export class TaskComponent {

  @Input()
  public inner? : Task;

  constructor() {
    console.log("task constructor" );
    console.log(this.inner);
   }

   ngOnInit(){   
      console.log("task onInit" );
      console.log(this.inner);     
   }
}
