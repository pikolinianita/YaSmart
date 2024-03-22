import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TaskComponent } from '../task/task.component';
import { IconComponent } from "../../common/icon/icon.component";
import { Icon } from '../../domain/icon';
import { Scenario } from '../../domain/scenario';
import { AddTaskComponent } from "./add-task/add-task.component";
import { TaskCreateDTO } from '../../domain/creation/task-create-dto';
import { TaskComplete } from '../../domain/toggle/task-complete';
import { DataService } from '../../service/data.service';

@Component({
    selector: 'app-scenario',
    standalone: true,
    templateUrl: './scenario.component.html',
    styleUrl: './scenario.component.css',
    imports: [TaskComponent, IconComponent, CommonModule, AddTaskComponent]
})
export class ScenarioComponent {

moveLifecycle() {

console.log("toggleTask");
console.log();
throw new Error('Method not implemented.');
}

toggleTask($event: TaskComplete) {
  console.log("toggleTask");
console.log($event);

throw new Error('Method not implemented.');
}

  // public reward = new Icon("aa-bb-icon" + Math.random(), 250, "monetization_on", "gold");
  // public reward2 = new Icon("aa-bb-icon" + Math.random(), 10, "local_pizza","brown");
 public fold = new Icon("aa-bb-icon" + Math.random(), 0, "arrow_downward", "gray");
  public finish = new Icon("aa-bb-icon" + Math.random(), 0, "arrow_forward","green");
  // public title = "Kolorowanie Angulara"
 
constructor(private dataService: DataService){
  console.log("scenario constructor")
  console.log(this.scenario);
}

ngOnInit(){
  console.log("scenario onInit");
  console.log(this.scenario);
}

  @Input()
  public scenario?: Scenario;

  public isFolded = false;

  toggleFold() {
    this.isFolded = !this.isFolded;
  }

createTask(task: TaskCreateDTO){
  console.log("createTask");
  throw new Error('Method not implemented.');
}

}
