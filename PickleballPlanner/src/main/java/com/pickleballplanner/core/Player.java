package com.pickleballplanner.core;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
@NamedQuery(
    name = "Player.findAll",
    query = "SELECT p FROM Player p"
)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "email")
    private String email;

    @Column(name = "invite_status")
    private String inviteStatus;

    public Player() {}

    public Player(String playerName, String email) {
        this.playerName = playerName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGameId() {
        return id;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

    public void setInviteStatus(String inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

}
