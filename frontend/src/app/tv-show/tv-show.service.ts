import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Show } from "./tv-show";

@Injectable({
  providedIn: 'root'
})

export class TVShowService {
  getShowUrl = "http://localhost:8080/api/tv-shows"
  constructor(private http: HttpClient) { }
  getShows(): Observable<Show[]> {
    return this.http.get<Show[]>(this.getShowUrl);
  }
}