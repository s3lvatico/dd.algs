package org.gmnz.ddi.algs.sorting;


import org.junit.Assert;
import org.junit.Test;


public class QuickSortTest {

    @Test
    public void testMergeSort() {
        int[] v = ArrayUtils.randomIntArray(10, 0, 50);
        while (ArrayUtils.isSorted(v)) {
            v = ArrayUtils.randomIntArray(10, 0, 50);
        }
        Assert.assertFalse(ArrayUtils.isSorted(v));
        QuickSort qs = new QuickSort(v);
        v = qs.sort();
        Assert.assertTrue(ArrayUtils.isSorted(v));
    }



    @Test
    public void knownArray() {
        int[] v = new int[] { 3, 4, 7, 6, 9, 1, 5, 2, 8 };
        QuickSort qs = new QuickSort(v);
        v = qs.sort();
        Assert.assertTrue(ArrayUtils.isSorted(v));
    }

}