package org.gmnz.ddi.algs.sort2;


import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * TestHeapSort
 */
public class TestHeapSort {

    @Test
    public void t0_heapsort() {
        Integer[] v = new Integer[] { 13, 35, 28, 21, 9, 3, 7, 27, 48, 38 };
        HeapSort<Integer> hs = new HeapSort<>(v);
        hs.sort();
        Assert.assertTrue(hs.isSorted());
    }



    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d ", new Random().nextInt(50));
        }
    }

}