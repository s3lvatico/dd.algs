package org.gmnz.ddi.algs.sorting;


import org.junit.Assert;
import org.junit.Test;


public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] v = ArrayUtils.randomIntArray(10, 0, 50);
        while (ArrayUtils.isSorted(v)) {
            v = ArrayUtils.randomIntArray(10, 0, 50);
        }
        Assert.assertFalse(ArrayUtils.isSorted(v));
        MergeSort mergeSort = new MergeSort(v);
        v = mergeSort.sort();
        Assert.assertTrue(ArrayUtils.isSorted(v));
    }

}