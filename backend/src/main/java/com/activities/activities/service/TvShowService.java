package com.activities.activities.service;

import com.activities.activities.model.Game;
import com.activities.activities.model.TvShow;
import com.activities.activities.repository.TvShowRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class TvShowService {
    private final TvShowRepository tvShowRepository;

    public TvShowService(TvShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    public List<TvShow> findAll() {
        return tvShowRepository.findAll();
    }

    public TvShow findById(Long id) {
        return tvShowRepository.findById(id).orElse(null);
    }

    public TvShow save(TvShow tvShow) {
        return tvShowRepository.save(tvShow);
    }

    public void deleteById(Long id) {
        tvShowRepository.deleteById(id);
    }

    public List<TvShow> findAllByName(String name) {
        return tvShowRepository.findAllByName(name);
    }

    public List<TvShow> findAllByRatingGreaterThan(Double rating) {
        return tvShowRepository.findAllByRatingGreaterThan(rating);
    }
    public void dataFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TvShow[] tvShows = mapper.readValue(Paths.get("app/jsonData/tv_shows.json").toFile(), TvShow[].class);
        tvShowRepository.saveAll(Arrays.asList(tvShows));
    }
}
