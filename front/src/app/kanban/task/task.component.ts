import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IconComponent } from "../../common/icon/icon.component";
import { Task } from '../../domain/task';
import { TaskComplete } from '../../domain/toggle/task-complete';

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

  @Output() toggleTask = new EventEmitter<TaskComplete>();

toggle(){
  //TODO
  console.log("task toggle");
  console.log("TODO");
  this.toggleTask.emit(new TaskComplete(this.inner?.id!));
}

}
