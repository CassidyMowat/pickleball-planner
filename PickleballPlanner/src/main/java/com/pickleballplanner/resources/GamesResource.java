package com.pickleballplanner.resources;

import com.codahale.metrics.annotation.Timed;
import com.pickleballplanner.core.Game;
import com.pickleballplanner.core.Player;
import com.pickleballplanner.db.dao.GameDAO;
import com.pickleballplanner.db.dao.PlayerDAO;

import io.dropwizard.hibernate.UnitOfWork;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
public class GamesResource {

    private static final String SUCCESS = "{\"status\": \"success\"}";

    private final GameDAO gameDAO;
    private final PlayerDAO playerDAO;

    public GamesResource(GameDAO gameDAO, PlayerDAO playerDAO) {
        this.gameDAO = gameDAO;
        this.playerDAO = playerDAO;
    }

    // Get a list of all games
    @GET
    @Timed
    @UnitOfWork
    public Response getGames() {
        return Response.status(Response.Status.OK)
                .entity(gameDAO.getGameList())
                .build();
    }

    // Get a specific game from the gameId
    @GET
    @Path("/{gameId}")
    @Timed
    @UnitOfWork
    public Response getGame(@PathParam("gameId") Long gameId) {

        return Response.status(Response.Status.OK)
                .entity(gameDAO.findById(gameId))
                .build();
    }

    // Create a new game
    @POST
    @Timed
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createGame(Game game) {

        // Takes a JSON representation of a game and adds it to the database
        gameDAO.create(game);

        return Response.ok().entity(SUCCESS).build();
    }

    // Add player to a game
    @POST
    @Path("/{gameId}/players")
    @Timed
    @UnitOfWork
    public Response addPlayerToGame(@PathParam("gameId") Long gameId, Player player) {

        player.setInviteStatus("Invited");
        player.setGameId(gameId);

        playerDAO.update(player);

        return Response.ok().entity(SUCCESS).build();
    }

    @PATCH
    @Path("/{gameId}/players/{playerId}")
    @Timed
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePlayerStatus(String playerStatus, @PathParam("gameId") Long gameId, @PathParam("playerId") Long playerId) {

        Player player = playerDAO.findById(playerId);
        player.setInviteStatus(playerStatus);

        return Response.ok().entity(SUCCESS).build();
    }

}

