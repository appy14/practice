package com.as.funexercises.ch4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphsTest {

    @Test
    public void testRoute() {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);

        n1.addNeighbor(n2);
        n1.addNeighbor(n3);
        n2.addNeighbor(n4);
        n4.addNeighbor(n3);

        assertTrue(Graphs.routeExists(n1, n4));
        assertFalse(Graphs.routeExists(n3, n4));
        assertTrue(Graphs.routeExists(n4, n3));
    }
}
