package org.carpooling.ws.serv.driver;


import org.carpooling.ws.map.Graph;

public class driverService {


    public driverService(){
    }

    public Graph getGraph(){
        return null;
    }


    public driver getDriver(){
        return driver.getInstance();
    }

    public driver startRide(String beginning, String end){
        return driver.getInstance().startRide(beginning, end);
    }


}
