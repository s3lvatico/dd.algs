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
        Point2d p2 = new Point2d();
        Assert.assertEquals(0, p1.compareTo(p2));
        Assert.assertEquals(0, p2.compareTo(p1));

        Point2d p3 = new Point2d(3, 4); // modulo = 5
        Point2d p4 = new Point2d(5, 5); // modulo > 7

        Assert.assertEquals(-1, p3.compareTo(p4));
        Assert.assertEquals(1, p4.compareTo(p3));
    }



    @Test
    public void propertyAccessors() {
        Point2d p0 = new Point2d();
        Assert.assertEquals(0d, p0.getA(), 0.00001d);
        Assert.assertEquals(0d, p0.getB(), 0.00001d);
        /**
         * un hash conosciuto
         */
        Assert.assertEquals(961, p0.hashCode());
    }



    @Test
    public void equivalence() {
        Point2d p0 = new Point2d();
        Assert.assertEquals(961, p0.hashCode());

        Assert.assertTrue(p0.equals(p0));
        Assert.assertFalse(p0.equals(null));
        Assert.assertFalse(p0.equals(new Object()));
        Assert.assertFalse(p0.equals(new Point2d(12, 0)));
        Assert.assertFalse(p0.equals(new Point2d(0, 23)));
        Assert.assertTrue(p0.equals(new Point2d(0, 0)));
    }

}