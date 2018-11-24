package org.carpooling.ws.serv.driver;

import org.carpooling.ws.map.Node;
import org.carpooling.ws.serv.ride.ride;

public class driver {

    private Node actualPosition;
    private static driver driver = null;
    private ride actualRide;


    private driver(){
        this.actualRide = new ride();
    }


    public static driver getInstance(){
        if (driver == null){
            driver = new driver();
        }
        return driver;
    }



    public void updateRide(String beginning, String mid, String end){
        driver.getActualRide().setBeginning(beginning);
        driver.getActualRide().setMid(mid);
        driver.getActualRide().setEnd(end);
    }

    public driver startRide(String beginning, String end){
        driver.getActualRide().setBeginning(beginning);
        driver.getActualRide().setEnd(end);
        return driver;
    }


    public Node getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(Node actualPosition) {
        this.actualPosition = actualPosition;
    }


    public ride getActualRide() {
        return actualRide;
    }

    public void setActualRide(ride actualRide) {
        this.actualRide = actualRide;
    }
}
