package org.carpolling.ws.map;

import org.carpooling.ws.map.Graph;
import org.carpooling.ws.map.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    @Test
    void dijkstra() {
        // Sets a HashMap
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        HashMap<Node<String>, Integer> map = new HashMap<>();
        map.put(b, 11);
        map.put(e, 3);
        a.setAdjacent(map);

        map = new HashMap<>();
        map.put(d, 2);
        b.setAdjacent(map);

        map = new HashMap<>();
        map.put(d, 2);
        b.setAdjacent(map);

        map = new HashMap<>();
        map.put(b, 4);
        map.put(d, 1);
        c.setAdjacent(map);

        map = new HashMap<>();
        map.put(b, 2);
        map.put(c, 1);
        map.put(e, 5);
        d.setAdjacent(map);

        map = new HashMap<>();
        map.put(a, 3);
        map.put(d, 5);
        e.setAdjacent(map);

        // Sets the Graph
        List<Node<String>> nodes = new ArrayList<>();
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);

        Graph graph = new Graph();
        graph.setVertices(nodes);

        // Validations
        var matrixA = graph.dijkstra(a);
        assertEquals(9, matrixA.get(c).getFirst().intValue(), "The minimum distance from A to C must be 9");
        assertEquals(10, matrixA.get(b).getFirst().intValue(), "The minimum distance from A to B must be 10");
        assertEquals(d, matrixA.get(b).getSecond(), "The predecessor from A to B must be D");

        var matrixB = graph.dijkstra(d);
        assertEquals(8, matrixB.get(a).getFirst().intValue(), "The minimum distance from D to A must be 8");
        assertEquals(2, matrixB.get(b).getFirst().intValue(), "The minimum distance from D to B must be 2");
        assertEquals(e, matrixB.get(a).getSecond(), "The predecessor from D to A must be E");
    }
}
