package org.gmnz.ddi.algs.graph3;


import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;


public class BfsTest {

    @Test
    public void bfs() {
        Graph g;
        try (Scanner s = new Scanner(BasicGraphTest.class.getResourceAsStream("/tinyGraph.txt"))) {
            g = new BasicGraph(s);
        }
        Bfs bfs = new Bfs(g, 7);
        Assert.assertEquals(2, bfs.count());

        bfs = new Bfs(g, 9);
        Assert.assertEquals(4, bfs.count());

        bfs = new Bfs(g, 5);
        Assert.assertEquals(7, bfs.count());
    }

}