package org.carpooling.ws.serv.driver;

import org.carpooling.ws.map.Graph;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/driver")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class DriverResource {

    private driverService driverService = new driverService();

    @GET
    @Path("/{graph}")
    public Graph getGraph(){
        return driverService.getGraph();
    }

    @GET
    @Path("/{getDriver}")
    public driver getDriver(){
        return driverService.getDriver();
    }

    @POST
    @Path("/begin = {beginning}, end = {ending}")
    public driver startRide(@PathParam("beginning")String begin, @PathParam("ending")String end){
        return driverService.startRide(begin, end);
    }


}
