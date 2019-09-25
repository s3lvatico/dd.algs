package org.gmnz.ddi.algs.graph3;


import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;


public class BasicGraphTest {


    @Test
    public void scannerCreation() {
        Scanner s = new Scanner(BasicGraphTest.class.getResourceAsStream("/tinyGraph.txt"));
        Assert.assertNotNull(s);
        s.close();
    }



    @Test
    public void dataFileRead() {
        try (Scanner s = new Scanner(BasicGraphTest.class.getResourceAsStream("/tinyGraph.txt"))) {
            Assert.assertEquals(13, s.nextInt());
            int edges = s.nextInt();
            Assert.assertEquals(13, edges);

            Assert.assertEquals(0, s.nextInt());
            Assert.assertEquals(5, s.nextInt());
            Assert.assertEquals(4, s.nextInt());
            Assert.assertEquals(3, s.nextInt());
            Assert.assertEquals(0, s.nextInt());
            Assert.assertEquals(1, s.nextInt());
            Assert.assertEquals(9, s.nextInt());
            Assert.assertEquals(12, s.nextInt());

            // ce ne sono anche altri
        }
    }

    @Test public void graphCreation() {
        Graph g;
        try (Scanner s = new Scanner(BasicGraphTest.class.getResourceAsStream("/tinyGraph.txt"))) {
            g = new BasicGraph(s);
            System.out.println(g);
        }
    }
}