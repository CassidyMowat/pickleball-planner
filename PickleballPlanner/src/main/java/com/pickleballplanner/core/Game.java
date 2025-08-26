package com.pickleballplanner.core;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "games")
@NamedQuery(
    name = "Game.findAll",
    query = "SELECT g FROM Game g"
)
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "game_date")
    private LocalDate gameDate;

    @Column(name = "game_location")
    private String gameLocation;

    @Column(name = "game_description")
    private String gameDescription;

    public Game() {}

    public Game(String title, LocalDate gameDate, String gameLocation, String gameDescription) {
        this.title = title;
        this.gameDate = gameDate;
        this.gameLocation = gameLocation;
        this.gameDescription = gameDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(String gameLocation) {
        this.gameLocation = gameLocation;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

}
