package org.carpooling.ws.map;

import java.util.HashMap;

public class Node <T> {

    private T element = null;
    private HashMap<Node<T>, Integer> map = new HashMap<>();  // Connections and their magnitudes with this Node

    public Node(){}

    public Node(T element){
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public HashMap<Node<T>, Integer> getMap() {
        return map;
    }

    public void setMap(HashMap<Node<T>, Integer> map) {
        this.map = map;
    }
}
