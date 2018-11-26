package org.carpooling.ws.server.map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/map")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MapResource {

    private static Graph map = MapGenerator.generateGraph(30);

    @GET
    public String getMap() {
        String mapAsString = "";
        try {
            mapAsString = new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            //e.printStackTrace();
        }
        return mapAsString;
    }

}
