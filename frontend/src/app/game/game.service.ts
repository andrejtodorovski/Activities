import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from './game';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  getGamesUrl = 'http://localhost:8080/api/games';
  constructor(private http: HttpClient) {}
  getGames(): Observable<Game[]> {
    return this.http.get<Game[]>(this.getGamesUrl);
  }
}
