package com.as.funexercises.ch4;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    int id;
    List<GraphNode> neighbors;

    public GraphNode() {
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int id) {
        this();
        this.id = id;
    }

    public List<GraphNode> getNeighbors() {
        // TODO: should return a copy
        return neighbors;
    }

    public void addNeighbor(GraphNode n) {
        if (n == null) {
            throw new IllegalArgumentException("Cannot add null node");
        }
        neighbors.add(n);
    }
}
