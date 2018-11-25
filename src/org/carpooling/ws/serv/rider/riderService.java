package org.carpooling.ws.serv.rider;

import org.carpooling.ws.map.Node;
import org.carpooling.ws.serv.driver.driver;

public class riderService {

    public driver getDriver(){
        return driver.getInstance();
    }

    public void updateRide(String mid, String end){
        rider.getInstance().requestRide(mid, end);
    }


}
