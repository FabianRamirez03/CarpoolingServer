package org.carpooling.ws.serv.rider;

import org.carpooling.ws.serv.driver.DriverResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class riderApplication extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(riderResource.class );
        return h;
    }
}
