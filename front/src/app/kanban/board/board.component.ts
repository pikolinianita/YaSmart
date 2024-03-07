import { Component } from '@angular/core';
import { ScenarioComponent } from "../scenario/scenario.component";
import { Icon } from '../../domain/icon';
import { Task } from '../../domain/task';
import { Scenario } from '../../domain/scenario';
import { DataService } from '../../service/data.service';

@Component({
    selector: 'app-board',
    standalone: true,
    templateUrl: './board.component.html',
    styleUrl: './board.component.css',
    imports: [ScenarioComponent]
})
export class BoardComponent {

    public reward = new Icon("aa-bb-icon 12 "+ Math.random(), 25, "monetization_on", "gold");
    public time = new Icon("aa-bb-icon 13 "+ Math.random(), 10, "access_time","blue");
    public inner = new Task("aa-bb-task 10"+ Math.random(), "Silly Text", this.reward, this.time);
    public t1 = new Task("aa-bb-task 09"+ Math.random(), "Not-Silly-Test", this.reward, this.time);
    public t2 = new Task("aa-bb-task 08"+ Math.random(), "Exceptional Text", this.reward, this.time);
    public tasks = [this.inner,this.t1,this.t2];
    public scen = new Scenario("aa-bb-scenario 07"+ Math.random(), "Kolorowanie Angulara","F", "A", [this.t1,this.t2,this.t1],[this.reward]);
    public scen2 = new Scenario("aa-cc-scenario 06"+ Math.random(), "killowanie cssa","NF", "B", [this.inner, this.t1,this.t2,this.t1],[this.reward]);

    
    public done! : Scenario[];
    public running! : Scenario[];
    public toDo! : Scenario[];
    
    constructor(private dataService: DataService) { 
        console.log("Board constructor");
        dataService.getScenarionsForBoard().subscribe(data=>
            {
                console.log(data);
                this.running = data.filter(s => s.state ==="STARTED");
                this.toDo = data.filter(s => s.state ==="NOT_STARTED");
                this.done = data.filter(s => s.state ==="FINISHED");
            });
    }


    ngOnInit() {
        console.log("Board onInit");
    }

}
