package com.activities.activities.repository;

import com.activities.activities.model.Game;
import com.activities.activities.model.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {
    List<TvShow> findAllByName(String name);
    List<TvShow> findAllByRatingGreaterThan(Double rating);
}
