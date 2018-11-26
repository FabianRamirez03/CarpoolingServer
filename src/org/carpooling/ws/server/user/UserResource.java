package org.carpooling.ws.server.user;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserService userService = new UserService();

    @GET
    @Path("/{user_id}")
    public User getUser(@PathParam("user_id") int id) {
        return userService.getUser(id);
    }

    @POST
    @Path("/register")
    public void newUser(User user) {
        userService.newUser(user);
    }

}
