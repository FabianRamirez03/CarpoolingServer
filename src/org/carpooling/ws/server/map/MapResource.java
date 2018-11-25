package org.carpooling.ws.server.map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/map")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MapResource {

    private static Graph map = MapGenerator.generateGraph(30);

    @GET
    public Graph getUser() {
        return map;
    }

}
