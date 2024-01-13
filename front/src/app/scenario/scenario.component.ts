import { Component, Input } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { TaskComponent } from '../task/task.component';
import { IconComponent } from "../icon/icon.component";
import { Icon } from '../domain/icon';
import { Scenario } from '../domain/scenario';

@Component({
    selector: 'app-scenario',
    standalone: true,
    templateUrl: './scenario.component.html',
    styleUrl: './scenario.component.css',
    imports: [TaskComponent, IconComponent, CommonModule]
})
export class ScenarioComponent {

  public reward = new Icon("aa-bb-icon", 250, "monetization_on", "gold");
  public reward2 = new Icon("aa-bb-icon", 10, "local_pizza","brown");
  public move = new Icon("aa-bb-icon", 0, "arrow_back", "gray");
  public finish = new Icon("aa-bb-icon", 0, "arrow_forward","green");
  public title = "Kolorowanie Angulara"

  @Input()
  public scenario?: Scenario;
  
  
}
