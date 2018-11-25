package org.carpooling.ws.serv.ride;

import org.carpooling.ws.map.Node;

public class ride {

    private String beginning;
    private String mid;
    private String end;


    public ride(){
    }
    public ride (String n1, String n2){
        this.setBeginning(n1);
        this.setEnd(n2);
    }
    public ride (String beginning, String mid, String end){
        this.setBeginning(beginning);
        this.setMid(mid);
        this.setEnd(end);
    }


    public ride mergeRides(String beginning, String mid, String end){
        ride ride = new ride(beginning,mid, end);
        return ride;
    }




    //Getters and Setters

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
