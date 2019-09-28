package org.gmnz.ddi.algs.util;


import org.junit.Assert;
import org.junit.Test;


/**
 * TestCplx
 */
public class TestCplx {

    @Test
    public void modulus() {
        Point2d p1 = new Point2d();
        p1.setA(-.5d);
        p1.setB(.9d);
        Assert.assertTrue(p1.modulus() < 1.41d);
    }



    @Test
    public void comparations() {
        Point2d p1 = new Point2d();
        p1.setA(-.5d);
        p1.setB(.9d);

        Point2d p2 = new Point2d();
        p2.setA(1);
        p2.setB(1);
        // System.out.println(p2.modulus());
        Assert.assertEquals(1.414d, p2.modulus(), .0005);

        Assert.assertTrue(p1.compareTo(p2) < 0);
    }

}