import { Component } from '@angular/core';
import { TaskComponent } from "../../kanban/task/task.component";
import { ScenarioComponent } from "../../kanban/scenario/scenario.component";
import { BoardComponent } from "../../kanban/board/board.component";
import { K1Component } from "../k1/k1.component";
import { K2Component } from "../k2/k2.component";
import { K3Component } from "../k3/k3.component";

@Component({
    selector: 'app-garbage',
    standalone: true,
    templateUrl: './garbage.component.html',
    styleUrl: './garbage.component.css',
    imports: [TaskComponent, ScenarioComponent, BoardComponent, K1Component, K2Component, K3Component]
})
export class GarbageComponent {

}
