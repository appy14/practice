package com.as.funexercises.ch4;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Stack;

public class Graphs {

    // Uses dfs - Ex 4.2
    public static boolean routeExists(GraphNode src, GraphNode dest) {
        if (src == null || dest == null) {
            throw new IllegalArgumentException();
        }

        boolean found = false;

        Stack<GraphNode> toExplore = new Stack<GraphNode>();
        Set<GraphNode> visited = new HashSet<GraphNode>();

        visited.add(src);
        toExplore.push(src);

        while (!toExplore.isEmpty()) {
            GraphNode n = toExplore.pop();

            if (n == dest) {
                found = true;
                break;
            }

            List<GraphNode> neighbors = n.getNeighbors();
            ListIterator<GraphNode> iterator = neighbors.listIterator(neighbors
                    .size());

            while (iterator.hasPrevious()) {
                GraphNode neighbor = iterator.previous();
                if (!visited.contains(neighbor)) {
                    toExplore.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return found;
    }
}
