package com.pickleballplanner.db.dao;

import com.pickleballplanner.core.Player;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PlayerDAO extends AbstractDAO<Player> {

    public PlayerDAO(SessionFactory factory) {
        super(factory);
    }

    public Player findById(Long id) {
        return get(id);
    }

    public Player create(Player player) {
        return persist(player);
    }

    public Player update(Player player) {
        return persist(player);
    }

    public List<Player> getPlayerList() {
        return list(namedTypedQuery("Player.findAll"));
    }

}
