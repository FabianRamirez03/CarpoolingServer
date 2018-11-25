package org.carpooling.ws.serv.rider;

import org.carpooling.ws.map.Node;
import org.carpooling.ws.serv.driver.driver;



public class rider {

    private Node actualPosition;
    private static rider rider = null;

    private rider() {
    }

    public static rider getInstance(){
        if (rider == null){
            rider = new rider();
        }
        return rider;
    }

    public void requestRide(String mid, String end){
        driver Driver = driver.getInstance();
        if (Driver.getActualRide().getEnd() == end){
            String start = Driver.getActualRide().getBeginning();
            driver.getInstance().updateRide(start, mid, end);
        }
    }

    public Node getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(Node actualPosition) {
        this.actualPosition = actualPosition;
    }
}
