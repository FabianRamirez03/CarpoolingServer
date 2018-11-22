package org.carpooling.ws.map;

import org.carpooling.util.DoubleArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private List<Node<String>> vertices = new ArrayList<>();
    private HashMap<Node<String>, DoubleArray<Integer, Node<String>>> matrix = new HashMap<>(); // Node, [Distance, Predecessor]

    public Graph() {
    }

    public final HashMap<Node<String>, DoubleArray<Integer, Node<String>>> dijkstra(Node<String> node) {
        List<Node<String>> V = new ArrayList<>();
        List<Node<String>> NV = new ArrayList<>();

        // Sets the matrix with magnitudes -1 and predecessors null
        matrix.clear();
        for (Node<String> n : vertices) {
            DoubleArray<Integer, Node<String>> array = new DoubleArray<>(-1, null);
            matrix.put(n, array);
        }

        // Enters a loop that set the nodes minimum distances
        dijkstra(node, node, V, NV);
        for (int i = 0; i < NV.size(); i++) {
            dijkstra(node, NV.get(i), V, NV);
        }
        return matrix;
    }

    private void dijkstra(Node<String> node, Node<String> current, List<Node<String>> V, List<Node<String>> NV) {
        // Manages the lists
        V.add(current);

        // Process the node
        if (current.equals(node)) matrix.get(current).setFirst(0);
        int last_distance = matrix.get(current).getFirst();

        current.getAdjacent().forEach((k, v) -> {
            var n = matrix.get(k);
            int distance = n.getFirst();
            if (distance == -1 || (v + last_distance) < distance) {
                n.setFirst(v + last_distance);
                n.setSecond(current);
            }

            if (!V.contains(k) && !NV.contains(k)) NV.add(k);
        });
    }

    public List<Node<String>> getVertices() {
        return vertices;
    }

    public void setVertices(List<Node<String>> vertices) {
        this.vertices = vertices;
    }
}
