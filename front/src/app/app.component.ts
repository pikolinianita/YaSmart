import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { K1Component } from './k1/k1.component';
import { K2Component } from './k2/k2.component';
import { K3Component } from './k3/k3.component';
import { TaskComponent } from './task/task.component';
import { ScenarioComponent } from "./scenario/scenario.component";
import { BoardComponent } from "./board/board.component";
import { LeftMenuComponent } from "./left-menu/left-menu.component";

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
