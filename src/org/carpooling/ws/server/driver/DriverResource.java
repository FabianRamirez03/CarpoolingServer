package org.carpooling.ws.server.driver;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/drivers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DriverResource {

    private DriverService driverService = new DriverService();

    @GET
    @Path("/{driver_id}")
    public Driver getDriver(@PathParam("driver_id") int id) {
        return driverService.getDriver(id);
    }

    @POST
    @Path("/register")
    public void newDriver(Driver driver) {
        driverService.newDriver(driver);
    }

}
