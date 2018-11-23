package org.carpooling.ws.serv.driver;

import org.carpooling.ws.map.Node;
import org.carpooling.ws.serv.ride.ride;

public class driver {

    private Node actualPosition;
    private static driver driver = null;
    private ride actualRide;


    public driver(){

        this.actualRide = new ride();

    }

    public static void addDriver(driver driver){
    }

    public static driver getInstance(){
        if (driver == null){
            driver = new driver();
        }
        return driver;
    }





    public Node getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(Node actualPosition) {
        this.actualPosition = actualPosition;
    }


}
