import { Component } from '@angular/core';
import { Game } from './game';
import { GameService } from './game.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css'],
})
export class GameComponent {
  ngOnInit(): void {
    this.form = this.fb.group({
      genre: [''],
    });
    this.getAllGames();
    this.getAllGenres();
  }
  constructor(private gameService: GameService, private fb:FormBuilder) {}
  genre: string | null = null;
  form:FormGroup = new FormGroup({})
  games: Game[] = [];
  genres: string[] = [];

  getAllGames(): void {
    this.gameService.getGames().subscribe((games) => (this.games = games));
  }
  getAllGamesByGenre(genre: string): void {
    this.gameService
      .getGamesByGenre(genre)
      .subscribe((games) => (this.games = games));
  }
  getAllGenres(): void {
    this.gameService
      .getGenres()
      .subscribe((genres) => (this.genres = genres));
  }
  onChange(): void 
  { 
    this.genre = this.form.get('genre')?.value;
    if (this.genre != null) {
      this.getAllGamesByGenre(this.genre);
    } else {
      this.getAllGames();
    }
  }
}
