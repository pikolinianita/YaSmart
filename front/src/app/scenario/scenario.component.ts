import { Component } from '@angular/core';
import { TaskComponent } from '../task/task.component';
import { IconComponent } from "../icon/icon.component";
import { Icon } from '../domain/icon';

@Component({
    selector: 'app-scenario',
    standalone: true,
    templateUrl: './scenario.component.html',
    styleUrl: './scenario.component.css',
    imports: [TaskComponent, IconComponent]
})
export class ScenarioComponent {

  public reward = new Icon("aa-bb-icon", 250, "monetization_on", "gold");
  public reward2 = new Icon("aa-bb-icon", 10, "local_pizza","brown");
  public title = "Kolorowanie Angulara"
}
