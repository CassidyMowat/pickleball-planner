package com.pickleballplanner.resources;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.hibernate.UnitOfWork;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
public class GamesResource {

    private static final String SUCCESS = "{\"status\": \"success\"}";

    @GET
    @Timed
    @UnitOfWork
    public Response getKart() {

        return Response.status(Response.Status.OK)
                .entity(SUCCESS)
                .build();
    }

}

