package org.gmnz.ddi.algs.sorting;


import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * ArrayUtilsTest
 */
public class ArrayUtilsTest {

    @Test
    public void sortedArrays() {
        int[] v = null;
        Assert.assertTrue(ArrayUtils.isSorted(v));
        v = new int[] {};
        Assert.assertTrue(ArrayUtils.isSorted(v));
        v = new int[] { 64 };
        Assert.assertTrue(ArrayUtils.isSorted(v));
        v = new int[] { 64, 42, 128 };
        Assert.assertFalse(ArrayUtils.isSorted(v));

        v = new int[] { 1, 2, 3 };
        Assert.assertTrue(ArrayUtils.isSorted(v));
    }



    @Test
    public void randomIntArray() {
        int[] v = ArrayUtils.randomIntArray(-1, 13, 4);
        Assert.assertNull(v);

        Assert.assertEquals(0, ArrayUtils.randomIntArray(0, 1, 2).length);

        final int REPETITIONS = 100;
        final Random rnd = new Random();
        for (int rep = 0; rep < REPETITIONS; rep++) {
            int lo = Integer.MIN_VALUE + rnd.nextInt(Integer.MAX_VALUE);
            int hi = rnd.nextInt(Integer.MAX_VALUE);
            int length = 1 + rnd.nextInt(100000);
            v = ArrayUtils.randomIntArray(length, lo, hi);
            Assert.assertEquals(length, v.length);
            for (int x : v) {
                Assert.assertTrue(x >= lo && x < hi);
            }
            v = ArrayUtils.randomIntArray(length, hi, lo);
            Assert.assertEquals(length, v.length);
            for (int x : v) {
                Assert.assertTrue(x >= lo && x < hi);
            }

        }
        System.out.println("Sample string representation of an array");
        int lo = Integer.MIN_VALUE + rnd.nextInt(Integer.MAX_VALUE);
        int hi = rnd.nextInt(Integer.MAX_VALUE);
        int length = 1 + rnd.nextInt(Byte.MAX_VALUE);
        v = ArrayUtils.randomIntArray(length, lo, hi);
        System.out.println(ArrayUtils.toString(v));
    }



    @Test
    public void randomDoubleArray() {
        Assert.assertNull(ArrayUtils.randomDoubleArray(-Math.abs(new Random().nextInt()), 0.0d, 0.0d));
        double[] dblv = ArrayUtils.randomDoubleArray(0, 0.0d, 0.0d);
        Assert.assertNotNull(dblv);
        Assert.assertEquals(0, dblv.length);

        Random rnd = new Random();
        int lowerBound = rnd.nextInt();
        int range = Math.abs(rnd.nextInt());
        int length = rnd.nextInt(Byte.MAX_VALUE);
        dblv = ArrayUtils.randomDoubleArray(length, lowerBound, range);
        Assert.assertNotNull(dblv);
        for (double d : dblv) {
            Assert.assertTrue(d >= lowerBound && d <= lowerBound + range);
        }
    }
}