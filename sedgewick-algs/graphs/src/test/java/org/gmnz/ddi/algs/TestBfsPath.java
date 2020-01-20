package org.gmnz.ddi.algs;


import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;


public class TestBfsPath {

    @Test
    public void bfsPathTest() {
        Graph g = null;

        try (Scanner s = new Scanner(GraphCreationTest.class.getResourceAsStream("/tinyGraph.txt"), "UTF-8")) {
            g = GraphFactory.createGraph(s);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        GraphUtils.printInfo(g);


        BfsPaths bfs;
        for (int j = 0; j < 7; j++) {
            bfs = new BfsPaths(g, j);
            for (int i = 0; i < g.V(); i++) {
                if (i < 7) {
                    Assert.assertTrue(bfs.hasPathTo(i));
                    List<Integer> path = new ArrayList<>();
                    bfs.pathTo(i).forEach(path::add);

                    System.out.printf("%2d --> %2d: [L:%2d] ", j, i, path.size());
                    path.forEach(pp -> System.out.printf("%d ", pp));
                    System.out.println();
                }
                else {
                    Assert.assertFalse(bfs.hasPathTo(i));
                    System.out.printf("%2d --> %2d: no path%n", j, i);
                }
            }
            System.out.println();
        }

        for (int j = 7; j < 9; j++) {
            bfs = new BfsPaths(g, j);
            for (int i = 0; i < g.V(); i++) {
                if (i >= 7 && i < 9) {
                    Assert.assertTrue(bfs.hasPathTo(i));
                    List<Integer> path = new ArrayList<>();
                    bfs.pathTo(i).forEach(path::add);

                    System.out.printf("%2d --> %2d: [L:%2d] ", j, i, path.size());
                    path.forEach(pp -> System.out.printf("%d ", pp));
                    System.out.println();
                }
                else {
                    Assert.assertFalse(bfs.hasPathTo(i));
                    System.out.printf("%2d --> %2d: no path%n", j, i);
                }
            }
            System.out.println();
        }
        for (int j = 9; j < 13; j++) {
            bfs = new BfsPaths(g, j);
            for (int i = 0; i < g.V(); i++) {
                if (i >= 9 && i < 13) {
                    Assert.assertTrue(bfs.hasPathTo(i));
                    List<Integer> path = new ArrayList<>();
                    bfs.pathTo(i).forEach(path::add);

                    System.out.printf("%2d --> %2d: [L:%2d] ", j, i, path.size());
                    path.forEach(pp -> System.out.printf("%d ", pp));
                    System.out.println();
                }
                else {
                    Assert.assertFalse(bfs.hasPathTo(i));
                    System.out.printf("%2d --> %2d: no path%n", j, i);
                }
            }
            System.out.println();
        }
    }

}