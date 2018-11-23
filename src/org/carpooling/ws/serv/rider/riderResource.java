package org.carpooling.ws.serv.rider;

import org.carpooling.ws.serv.driver.driver;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rider")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class riderResource {
    private riderService riderService = new riderService();

    @GET
    @Path("/(getDriver)")
    public driver getDriver(){
        return riderService.getDriver();
    }

}
