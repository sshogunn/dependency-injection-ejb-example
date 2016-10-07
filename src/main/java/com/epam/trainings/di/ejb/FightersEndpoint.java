package com.epam.trainings.di.ejb;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class FightersEndpoint {
    @EJB
    private FightersService fightersService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "hello: wildfly swarm + gradle + java";
    }
}
