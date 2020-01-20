package org.gmnz.ddi.algs;


import static org.junit.Assert.fail;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;


public class TestDfsPath {

    @Test
    public void dfsPathTest() {
        Graph g = null;

        try (Scanner s = new Scanner(GraphCreationTest.class.getResourceAsStream("/tinyGraph.txt"), "UTF-8")) {
            g = GraphFactory.createGraph(s);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        System.out.println(GraphUtils.toString(g));

        DfsPaths dfs = new DfsPaths(g, 0);
        for (int i = 0; i < 7; i++) {
            Assert.assertTrue(dfs.hasPathTo(i));
            System.out.printf("Path to %d: ", i);

            Iterable<Integer> path = dfs.pathTo(i);
            path.forEach(pp -> System.out.printf("%d ", pp));
            System.out.println();
        }
    }

}