package org.carpolling.ws.map;

import org.carpooling.ws.map.Graph;
import org.carpooling.ws.map.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GraphTest {

    @Test
    void dijkstra() {
        List<Node<String>> nodes = generateVertices();
        Graph graph = new Graph();
        graph.setVertices(nodes);

        Node<String> a = nodes.get(0);
        Node<String> b = nodes.get(1);
        Node<String> c = nodes.get(2);
        Node<String> d = nodes.get(3);
        Node<String> e = nodes.get(4);

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

    @Test
    void floyd_warshall() {
        List<Node<String>> nodes = generateVertices();
        Graph graph = new Graph();
        graph.setVertices(nodes);
        graph.floyd_warshall();

        Node<String> a = nodes.get(0);
        Node<String> b = nodes.get(1);
        Node<String> c = nodes.get(2);
        Node<String> d = nodes.get(3);
        Node<String> e = nodes.get(4);

        Integer[][] distances = graph.getDistances();
        Node<String>[][] predecessors = graph.getPredecessors();

        // Validations
        assertEquals(5, nodes.size(), " The vertices list must be 5");
        assertEquals(5, distances.length, "The matrix dimensions must be the same as vertices");
        assertEquals(5, predecessors.length, "The matrix dimensions must be the same as vertices");

        assertEquals(8, distances[0][3].intValue(), "The distance from A to D must be 8");
        assertEquals(e, predecessors[0][3], "The predecessor from A to D must be E");

        assertEquals(9, distances[2][0].intValue(), "The distance from C to A must be 9");
        assertEquals(e, predecessors[2][0], "The predecessor from C to A must be E");

        assertEquals(0, distances[4][4].intValue(), "The distance from E to E must be 0");
        assertNull(predecessors[4][4], "The predecessor from E to E must be null");

        assertEquals(3, distances[2][1].intValue(), "The distance from C to B must be 3");
        assertEquals(d, predecessors[2][1], "The predecessor from C to B must be D");

        assertEquals(3, distances[0][4].intValue(), "The distance from A to E must be 3");
        assertEquals(a, predecessors[0][4], "The predecessor from A to E must be A");

        assertEquals(2, distances[1][3].intValue(), "The distance from B to D must be 2");
        assertEquals(b, predecessors[1][3], "The predecessor from B to D must be B");

        assertEquals(1, distances[2][3].intValue(), "The distance from C to D must be 1");
        assertEquals(c, predecessors[2][3], "The predecessor from C to D must be C");
    }

    private List<Node<String>> generateVertices() {
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
        return nodes;
    }
}
