import { Component, OnInit } from '@angular/core';
import { TVShowService } from './tv-show.service';
import { Show } from './tv-show';

@Component({
  selector: 'app-tv-show',
  templateUrl: './tv-show.component.html',
  styleUrls: ['./tv-show.component.css']
})
export class TvShowComponent implements OnInit {
  ngOnInit(): void {
    this.getAllTvShows();
  }
  constructor(
    private tvShowService: TVShowService
  ) { }

  shows: Show[] = [];

  getAllTvShows(): void {
    this.tvShowService.getShows().subscribe(
      shows => this.shows = shows,
    );   
  }
  getAllByRating(event: Event): void {
    this.tvShowService.getShowsWithRatingAbove(parseFloat((event.target as HTMLInputElement).value)).subscribe(
      shows => this.shows = shows,
    );   
  }
}
