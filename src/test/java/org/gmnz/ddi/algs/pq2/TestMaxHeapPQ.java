package org.gmnz.ddi.algs.pq2;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestMaxHeapPQ {

    @Test
    public void sample() {
        Assert.assertTrue(true);
    }



    @Test
    public void constructorTest() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(0);
        assertEquals(0, heap.size());
    }



    @Test(expected = NegativeArraySizeException.class)
    public void constructorWrongTest() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(-2);
        assertEquals(0, heap.size());
    }



    @Test
    public void constructorPathologicSizeTest() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(-1);
        assertEquals(0, heap.size());
    }
}