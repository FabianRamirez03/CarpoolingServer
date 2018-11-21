package org.carpolling.ws.map;

import org.carpooling.ws.map.Node;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void constructor() {
        Node<Integer> node = new Node<>(5);

        assertEquals(5, node.getElement().intValue(), "Node element must be 5");
    }

    @Test
    void elementGettersAndSetters() {
        Node<Integer> node = new Node<>();

        assertNull(node.getElement(), "Node element must be null");
        node.setElement(5);
        assertEquals(5, node.getElement().intValue(), "Node element must be 5");
    }

    @Test
    void mapGettersAndSetters() {
        Node<Integer> node1 = new Node<>(5);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(4);

        // Sets connections
        HashMap<Node<Integer>, Integer> map = new HashMap<>();
        map.put(node2, 20);
        map.put(node3, 4);

        assertTrue(node1.getMap().isEmpty(), "Node map must be empty");
        node1.setMap(map);
        assertFalse(node1.getMap().isEmpty(), "Node map must not be empty");

        assertEquals(20, node1.getMap().get(node2).intValue(), "Node element must be 20");
        assertEquals(4, node1.getMap().get(node3).intValue(), "Node element must be 4");
    }
}
