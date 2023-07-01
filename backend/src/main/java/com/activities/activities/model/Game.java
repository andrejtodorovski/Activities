package com.activities.activities.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "games", schema = "public")
public class Game {
    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "TEXT")
    private String short_description;
    @Column(name = "image")
    private String thumbnail;
    @Column(name = "url")
    private String game_url;
    @Column(name = "genre")
    private String genre;
    @Column(name = "platform")
    private String platform;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "developer")
    private String developer;
    @Column(name = "release_date")
    private Date released;
}
