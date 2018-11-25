package org.carpolling.ws.map;

import org.carpooling.ws.server.map.Graph;
import org.carpooling.ws.server.map.MapGenerator;
import org.carpooling.ws.server.map.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapGeneratorTest {

    @Test
    void generateGraph() {
        Graph graph = MapGenerator.generateGraph(10);
        List<Node<String>> vertices = graph.getVertices();

        assertNotNull(graph, "The Graph must not be null");
        assertEquals(10, vertices.size(), "The Graph must have 10 Nodes");

        assertTrue(vertices.get(6).getAdjacent().size() > 0, "The Node connections must be greater than 1");
        assertTrue(vertices.get(8).getAdjacent().size() > 0, "The Node connections must be greater than 1");
        assertTrue(vertices.get(2).getAdjacent().size() > 0, "The Node connections must be greater than 1");
        assertTrue(vertices.get(4).getAdjacent().size() > 0, "The Node connections must be greater than 1");
    }
}
