package com.activities.activities.service;

import com.activities.activities.model.Game;
import com.activities.activities.repository.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public void deleteById(Long id) {
        gameRepository.deleteById(id);
    }

    public List<Game> findAllByTitle(String title) {
        return gameRepository.findAllByTitle(title);
    }

    public List<Game> findAllByGenre(String genre) {
        return gameRepository.findAllByGenre(genre);
    }

    public List<Game> findAllByGenreAndReleased(String genre, Date released) {
        return gameRepository.findAllByGenreAndReleasedAfter(genre, released);
    }
    public void dataFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Game[] games = mapper.readValue(Paths.get("app/jsonData/games.json").toFile(), Game[].class);
        gameRepository.saveAll(Arrays.asList(games));
    }
    public List<String> getGenres() {
        return gameRepository.findAll().stream().map(Game::getGenre).distinct().toList();
    }
}
