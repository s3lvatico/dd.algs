package org.gmnz.ddi.algs;

import static org.junit.Assert.fail;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class TestDepthFirstSearch {

    @Test
    public void dfsTest() {
        Graph g = null;

        try (Scanner s = new Scanner(GraphCreationTest.class.getResourceAsStream("/tinyGraph.txt"), "UTF-8")) {
            g = GraphFactory.createGraph(s);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        GraphUtils.printInfo(g);
        
        DepthFirstSearch dfs;
        for (int v = 0; v < g.V(); v++) {
            dfs = new DepthFirstSearch(g, v);
            System.out.format("Checking graph connectivity from vertex %d...", v);
            /*
             * il grafo che considero NON è connesso, perciò quale che sia il vertice di
             * partenza, il numero di vertici raggiungibili da quello di partenza sarà
             * sempre minore del numero di vertici del grafo
             */
            Assert.assertTrue(dfs.count() < g.V());
            System.out.println("ok!");
        }
    }

}