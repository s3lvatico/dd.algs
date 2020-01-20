package org.gmnz.ddi.algs;

import java.util.Scanner;

import org.junit.Test;

public class GraphCreationTest {

    @Test
    public void testGraphCreation() {
        Graph g = null;
        
        try (Scanner s = new Scanner(GraphCreationTest.class.getResourceAsStream("/tinyGraph.txt"), "UTF-8")) {
            g = GraphFactory.createGraph(s);
        } catch(Exception e) {
            e.printStackTrace();;
        }
        // System.out.println(GraphUtils.toString(g));
        GraphUtils.printInfo(g);
    }

}