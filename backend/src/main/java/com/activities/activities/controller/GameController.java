package com.activities.activities.controller;

import com.activities.activities.model.Game;
import com.activities.activities.service.GameService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/games")
@CrossOrigin("http://localhost:4200")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public Game findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @GetMapping("/title/{title}")
    public List<Game> findAllByTitle(@PathVariable String title) {
        return gameService.findAllByTitle(title);
    }

    @GetMapping("/genre/{genre}")
    public List<Game> findAllByGenre(@PathVariable String genre) {
        return gameService.findAllByGenre(genre);
    }

    @GetMapping("/filter")
    public List<Game> findAllByGenreAndReleased(@RequestParam String genre, @RequestParam Date released) {
        return gameService.findAllByGenreAndReleased(genre, released);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        gameService.deleteById(id);
    }

    @PostMapping("/add")
    public Game save(@RequestBody Game game) {
        return gameService.save(game);
    }

    @GetMapping("/dataFromJson")
    public void dataFromJson() throws IOException, ParseException {
        gameService.dataFromJson();
    }
}
