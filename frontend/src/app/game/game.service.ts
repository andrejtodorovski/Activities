import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from './game';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  getGamesUrl = 'http://localhost:80/api/games';
  constructor(private http: HttpClient) {}
  getGames(): Observable<Game[]> {
    return this.http.get<Game[]>(this.getGamesUrl);
  }
  getGamesByGenre(genre: string): Observable<Game[]> {
    return this.http.get<Game[]>(this.getGamesUrl + '/genre/' + genre);
  }
  getGame(id: number): Observable<Game> {
    return this.http.get<Game>(this.getGamesUrl + '/' + id);
  }
  getGenres(): Observable<string[]> {
    return this.http.get<string[]>(this.getGamesUrl + '/genres');
  }
}
