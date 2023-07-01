package com.activities.activities.repository;

import com.activities.activities.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findAllByTitle(String title);
    List<Game> findAllByGenre(String genre);
    List<Game> findAllByGenreAndReleasedAfter(String genre, Date released);
}
