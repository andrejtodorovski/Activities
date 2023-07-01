import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GameComponent } from './game/game.component';
import { TvShowComponent } from './tv-show/tv-show.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {
    path: 'games', component: GameComponent
  },
  {
    path: 'tv-shows', component: TvShowComponent
  },
  {
    path: '', component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
