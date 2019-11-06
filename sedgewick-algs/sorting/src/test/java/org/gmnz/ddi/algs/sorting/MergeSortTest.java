package org.gmnz.ddi.algs.sorting;


import org.junit.Assert;
import org.junit.Test;


public class MergeSortTest {

    @Test
    public void testMergeSort() {
        Integer[] v = ArrayUtils.randomIntegerArray(10, 0, 50);
        while (ArrayUtils.isSorted(v)) {
            v = ArrayUtils.randomIntegerArray(10, 0, 50);
        }
        Assert.assertFalse(ArrayUtils.isSorted(v));
        MergeSort<Integer> mergeSort = new MergeSort<>(v);
        v = mergeSort.sort();
        Assert.assertTrue(ArrayUtils.isSorted(v));
    }

}