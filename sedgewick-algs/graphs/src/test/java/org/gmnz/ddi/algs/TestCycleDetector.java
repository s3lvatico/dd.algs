package org.gmnz.ddi.algs;


import static org.junit.Assert.fail;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestCycleDetector {

    private Graph g;

    @Before
    public void beforeEachTest() {

        try (Scanner s = new Scanner(GraphCreationTest.class.getResourceAsStream("/tinyGraph.txt"), "UTF-8")) {
            g = GraphFactory.createGraph(s);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        GraphUtils.printInfo(g);
    }



    @Test
    public void cycleDetectorTest() {
        CycleDetector cd = new CycleDetector(g);
        Assert.assertTrue(cd.hasCycle());
        System.out.format("Provided graph has at least a cycle%n");
    }

}