import { Component } from '@angular/core';
import { TaskComponent } from "../../task/task.component";
import { ScenarioComponent } from "../../scenario/scenario.component";
import { BoardComponent } from "../../board/board.component";
import { Icon } from '../../domain/icon';
import { IconComponent } from "../../icon/icon.component";

@Component({
    selector: 'app-cards',
    standalone: true,
    templateUrl: './cards.component.html',
    styleUrl: './cards.component.css',
    imports: [TaskComponent, ScenarioComponent, BoardComponent, IconComponent]
})
export class CardsComponent {
  public reward = new Icon("aa-bb-icon", 250, "monetization_on", "gold");
}
