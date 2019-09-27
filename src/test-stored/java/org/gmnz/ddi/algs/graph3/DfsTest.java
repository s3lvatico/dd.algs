package org.gmnz.ddi.algs.graph3;


import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;


/**
 * DfsTest
 */
public class DfsTest {

    @Test
    public void dfsCount() {
        Graph g;
        try (Scanner s = new Scanner(BasicGraphTest.class.getResourceAsStream("/tinyGraph.txt"))) {
            g = new BasicGraph(s);
        }
        Dfs dfs = new Dfs(g, 0);
        Assert.assertEquals(7, dfs.count());
        for (int i = 0; i <= 6; i++) {
            Assert.assertTrue(dfs.marked(i));
        }
        for (int i = 7; i <= 12; i++) {
            Assert.assertFalse(dfs.marked(i));
        }

        dfs = new Dfs(g, 7);
        Assert.assertEquals(2, dfs.count());
        Assert.assertTrue(dfs.marked(7));
        Assert.assertTrue(dfs.marked(8));

        dfs = new Dfs(g, 10);
        Assert.assertEquals(4, dfs.count());
        for (int i = 0; i <= 8; i++) {
            Assert.assertFalse(dfs.marked(i));
        }

    }

}