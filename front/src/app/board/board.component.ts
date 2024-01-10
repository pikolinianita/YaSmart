import { Component } from '@angular/core';
import { ScenarioComponent } from "../scenario/scenario.component";

@Component({
    selector: 'app-board',
    standalone: true,
    templateUrl: './board.component.html',
    styleUrl: './board.component.css',
    imports: [ScenarioComponent]
})
export class BoardComponent {

}
