package org.carpooling.ws.server.user;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class UserResource {

    private UserService userService = new UserService();

    @GET
    @Path("/{user_id}")
    public String getUser(@PathParam("user_id") int id) {
        return userService.getUser(id);
    }

    @POST
    @Path("/register")
    public void newUser(String user) {
        userService.newUser(user);
    }

}
