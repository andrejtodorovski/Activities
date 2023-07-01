package com.activities.activities.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "tv_shows", schema = "public")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvShow{
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String officialSite;
    @Column(name = "language")
    private String language;
    @Column(name = "status")
    private String status;
    @Column(name = "runtime")
    private Integer runtime;
    @Column(name = "premiered")
    private Date premiered;
    @Column(name = "ended")
    private Date ended;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "image")
    private String image;
    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;
    @Column(name = "genres")
    private String genres;
}
