import { Component } from '@angular/core';
import { RouterLink, provideRouter } from '@angular/router';
import { routes } from '../../app.routes';

@Component({
  selector: 'app-left-menu',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './left-menu.component.html',
  styleUrl: './left-menu.component.css'
})
export class LeftMenuComponent {

}
