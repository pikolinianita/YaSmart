import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { K1Component } from './dev/k1/k1.component';
import { K2Component } from './dev/k2/k2.component';
import { K3Component } from './dev/k3/k3.component';
import { TaskComponent } from './kanban/task/task.component';
import { ScenarioComponent } from "./kanban/scenario/scenario.component";
import { BoardComponent } from "./kanban/board/board.component";
import { LeftMenuComponent } from "./common/left-menu/left-menu.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [CommonModule, RouterOutlet, K1Component, K2Component, K3Component, TaskComponent, ScenarioComponent, BoardComponent, LeftMenuComponent]
})
export class AppComponent {
  title = 'front'; 
}
