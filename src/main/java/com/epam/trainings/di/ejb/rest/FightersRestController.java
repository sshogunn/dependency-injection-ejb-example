package com.epam.trainings.di.ejb.rest;

import com.epam.trainings.di.ejb.service.FightersServiceBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/1.0/fighters")
@Api(value = "/fighters", description = "Fighters service")
public class FightersRestController {
    private final FightersServiceBean fightersService;

    @Inject
    public FightersRestController(FightersServiceBean fightersService) {
        this.fightersService = fightersService;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Provide the list of fighters names")
    public Response fightersNames() {
        return Response.ok(fightersService.getFightersNames()).build();
    }

}