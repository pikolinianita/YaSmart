import { Routes } from '@angular/router';
import { Err404Component } from './info/err404/err404.component';
import { BoardComponent } from './kanban/board/board.component';
import { CardsComponent } from './dev/cards/cards.component';
import { GarbageComponent } from './dev/garbage/garbage.component';

export const routes: Routes = [
    { path: 'app', component: BoardComponent },
    { path: 'cards', component: CardsComponent }, 
    { path: 'dev', component: GarbageComponent },       
    { path: '',   redirectTo: '/app', pathMatch: 'full' }, // redirect to `first-component`
    { path: '**', component: Err404Component },  // Wildcard route for a 404 page
];
