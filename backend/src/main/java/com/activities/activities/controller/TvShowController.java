package com.activities.activities.controller;

import com.activities.activities.model.TvShow;
import com.activities.activities.service.TvShowService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/tv-shows")
@CrossOrigin("http://localhost:4200")
public class TvShowController {
    private final TvShowService tvShowService;

    public TvShowController(TvShowService tvShowService) {
        this.tvShowService = tvShowService;
    }
    @GetMapping
    public List<TvShow> findAll() {
        return tvShowService.findAll();
    }

    @GetMapping("/{id}")
    public TvShow findById(@PathVariable Long id) {
        return tvShowService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<TvShow> findAllByName(@PathVariable String name) {
        return tvShowService.findAllByName(name);
    }

    @GetMapping("/rating/{rating}")
    public List<TvShow> findAllByRatingGreaterThan(@PathVariable Double rating) {
        return tvShowService.findAllByRatingGreaterThan(rating);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tvShowService.deleteById(id);
    }

    @PostMapping("/add")
    public TvShow save(@RequestBody TvShow tvShow) {
        return tvShowService.save(tvShow);
    }

    @GetMapping("/dataFromJson")
    public void dataFromJson() throws IOException, ParseException {
        tvShowService.dataFromJson();
    }
}
