package org.gmnz.hr;


import org.gmnz.ddi.algs.sorting.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;


public class CountingSortTest {

    @Test
    public void testCountingSort() {
        int[] v = ArrayUtils.randomIntArray(20, 0, 50);
        while (ArrayUtils.isSorted(v)) {
            v = ArrayUtils.randomIntArray(20, 0, 50);
        }
        CountingSort csort = new CountingSort(v);
        v = csort.sort();
        Assert.assertTrue(ArrayUtils.isSorted(v));
    }

}