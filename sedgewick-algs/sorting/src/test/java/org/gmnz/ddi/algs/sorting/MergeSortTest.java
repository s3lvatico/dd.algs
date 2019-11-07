package org.gmnz.ddi.algs.sorting;


import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


public class MergeSortTest {

    @Test
    public void testMergeSort() {
        Random rnd = new Random();
        final int ARRAY_SIZE = rnd.nextInt(Byte.MAX_VALUE);
        final int UPPER_BOUND = rnd.nextInt(Short.MAX_VALUE);
        Integer[] v = ArrayUtils.randomIntegerArray(ARRAY_SIZE, 0, UPPER_BOUND);
        while (ArrayUtils.isSorted(v)) {
            v = ArrayUtils.randomIntegerArray(ARRAY_SIZE, 0, UPPER_BOUND);
        }
        Assert.assertFalse(ArrayUtils.isSorted(v));
        MergeSort<Integer> mergeSort = new MergeSort<>(v);
        v = mergeSort.sort();
        Assert.assertTrue(ArrayUtils.isSorted(v));
    }

}