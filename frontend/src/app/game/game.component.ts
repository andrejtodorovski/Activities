import { Component } from '@angular/core';
import { Game } from './game';
import { GameService } from './game.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css'],
})
export class GameComponent {
  ngOnInit(): void {
    this.getAllGames();
  }
  constructor(private gameService: GameService) {}

  games: Game[] = [];

  getAllGames(): void {
    this.gameService.getGames().subscribe((games) => (this.games = games));
  }
}
