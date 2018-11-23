package org.carpooling.ws.serv.ride;

import org.carpooling.ws.map.Node;

public class ride {

    private Node beginning;
    private Node mid;
    private Node end;


    public ride(){
    }
    public ride (Node n1, Node n2){
        this.setBeginning(n1);
        this.setEnd(n2);
    }
    public ride (Node beginning, Node mid, Node end){
        this.setBeginning(beginning);
        this.setMid(mid);
        this.setEnd(end);
    }


    public ride mergeRides(Node beginning, Node mid, Node end){
        ride ride = new ride(beginning,mid, end);
        return ride;
    }




    //Getters and Setters

    public Node getBeginning() {
        return beginning;
    }

    public void setBeginning(Node beginning) {
        this.beginning = beginning;
    }

    public Node getMid() {
        return mid;
    }

    public void setMid(Node mid) {
        this.mid = mid;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }
}
