import { Routes } from '@angular/router';
import { K1Component } from './k1/k1.component';
import { K2Component } from './k2/k2.component';
import { K3Component } from './k3/k3.component';
import { Err404Component } from './info/err404/err404.component';
import { BoardComponent } from './board/board.component';
import { CardsComponent } from './dev/cards/cards.component';
import { GarbageComponent } from './dev/garbage/garbage.component';

export const routes: Routes = [
    { path: 'app', component: BoardComponent },
    { path: 'cards', component: CardsComponent },
    { path: 'dev', component: GarbageComponent },       
    { path: '',   redirectTo: '/app', pathMatch: 'full' }, // redirect to `first-component`
    { path: '**', component: Err404Component },  // Wildcard route for a 404 page
];
