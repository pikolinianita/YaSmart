import { Component } from '@angular/core';
import { ScenarioComponent } from "../scenario/scenario.component";
import { Icon } from '../../domain/icon';
import { Task } from '../../domain/task';
import { Scenario } from '../../domain/scenario';

@Component({
    selector: 'app-board',
    standalone: true,
    templateUrl: './board.component.html',
    styleUrl: './board.component.css',
    imports: [ScenarioComponent]
})
export class BoardComponent {

    public reward = new Icon("aa-bb-icon", 25, "monetization_on", "gold");
    public time = new Icon("aa-bb-icon", 10, "access_time","blue");
    public inner = new Task("aa-bb-task", "Silly Text", this.reward, this.time);
    public t1 = new Task("aa-bb-task", "Not-Silly-Test", this.reward, this.time);
    public t2 = new Task("aa-bb-task", "Exceptional Text", this.reward, this.time);
    public tasks = [this.inner,this.t1,this.t2];
    public scen = new Scenario("aa-bb-scenario", "Kolorowanie Angulara","A", [this.t1,this.t2,this.t1],[this.reward]);
    public scen2 = new Scenario("aa-cc-scenario", "killowanie cssa","B", [this.inner, this.t1,this.t2,this.t1],[this.reward]);

}
