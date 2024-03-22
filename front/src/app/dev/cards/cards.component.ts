import { Component } from '@angular/core';
import { TaskComponent } from "../../kanban/task/task.component";
import { ScenarioComponent } from "../../kanban/scenario/scenario.component";
import { BoardComponent } from "../../kanban/board/board.component";
import { Icon } from '../../domain/icon';
import { IconComponent } from "../../common/icon/icon.component";
import { LeftMenuComponent } from "../../common/left-menu/left-menu.component";
import { Task } from '../../domain/task';
import { Scenario } from '../../domain/scenario';
import { IconEditableComponent } from "../../common/icon-editable/icon-editable.component";

@Component({
    selector: 'app-cards',
    standalone: true,
    templateUrl: './cards.component.html',
    styleUrl: './cards.component.css',
    imports: [TaskComponent, ScenarioComponent, BoardComponent, IconComponent, LeftMenuComponent, IconEditableComponent]
})
export class CardsComponent {
  public reward = new Icon("aa-bb-icon", 250, "monetization_on", "gold");
  public time = new Icon("aa-bb-icon", 10, "access_time","blue");
  public inner = new Task("aa-bb-task", "Silly Text", this.reward, this.time);
  public t1 = new Task("aa-bb-task", "Not-Silly-Test", this.reward, this.time);
  public t2 = new Task("aa-bb-task", "Exceptional Text", this.reward, this.time);
  public tasks = [this.inner,this.t1,this.t2];
  public scen = new Scenario("aa-bb-scenario", "Kolorowanie Angulara","STARTED" ,"C", [this.t1,this.t2,this.t1],[this.reward]);

}
