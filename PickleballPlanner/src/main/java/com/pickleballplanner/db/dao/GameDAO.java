package com.pickleballplanner.db.dao;

import com.pickleballplanner.core.Game;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class GameDAO extends AbstractDAO<Game> {

    public GameDAO(SessionFactory factory) {
        super(factory);
    }

    public Game findById(Long id) {
        return get(id);
    }

    public Game create(Game game) {
        return persist(game);
    }

    public Game update(Game game) {
        return persist(game);
    }

    public List<Game> getGameList() {
        return list(namedTypedQuery("Game.findAll"));
    }

}
