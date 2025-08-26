package com.pickleballplanner.resources;

import com.codahale.metrics.annotation.Timed;
import com.pickleballplanner.core.Player;
import com.pickleballplanner.db.dao.PlayerDAO;

import io.dropwizard.hibernate.UnitOfWork;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    private static final String SUCCESS = "{\"status\": \"success\"}";

    private final PlayerDAO playerDAO;

    public PlayerResource(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    // Get a list of all players
    @GET
    @Timed
    @UnitOfWork
    public Response getGames() {
        return Response.status(Response.Status.OK)
                .entity(playerDAO.getPlayerList())
                .build();
    }

    // Get a specific player from a given ID
    @GET
    @Path("/{playerId}")
    @Timed
    @UnitOfWork
    public Response getGame(@PathParam("playerId") Long playerId) {

        return Response.status(Response.Status.OK)
                .entity(playerDAO.findById(playerId))
                .build();
    }

    // Create a new player
    @POST
    @Timed
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlayer(Player player) {

        // Takes a JSON representation of a player and adds it to the database
        playerDAO.create(player);

        return Response.ok().entity(SUCCESS).build();
    }

}

