package org.carpooling.ws.server.driver;

import java.util.ArrayList;
import java.util.List;

public class DriverService {

    public static List<Driver> drivers = new ArrayList<>();

    public Driver getDriver(int id) {
        return drivers.get(id);
    }

    public void newDriver(Driver driver) {
        drivers.add(driver);
    }
}
