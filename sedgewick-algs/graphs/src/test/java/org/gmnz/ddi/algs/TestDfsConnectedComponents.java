package org.gmnz.ddi.algs;


import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;


public class TestDfsConnectedComponents {

    @Test
    public void dfsConnectedComponentsTest() {
        Graph g = null;

        try (Scanner s = new Scanner(GraphCreationTest.class.getResourceAsStream("/tinyGraph.txt"), "UTF-8")) {
            g = GraphFactory.createGraph(s);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        GraphUtils.printInfo(g);

        DfsCC dfsCc = new DfsCC(g);
        Assert.assertEquals(3, dfsCc.count());

        for (int i = 0; i < g.V(); i++) {
            System.out.printf("Node %2d : component %d%n", i, dfsCc.id(i));
        }

        Collection<Integer> p0 = dfsCc.findPath(0, 3);
        System.out.println(p0);
        System.out.println(dfsCc.findPath(11, 9));
        System.out.println(dfsCc.findPath(9, 11));
    }

}