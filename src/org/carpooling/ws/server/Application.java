package org.carpooling.ws.server;

import org.carpooling.ws.server.driver.DriverResource;
import org.carpooling.ws.server.user.UserResource;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class Application extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(DriverResource.class);
        h.add(UserResource.class);
        return h;
    }
}
