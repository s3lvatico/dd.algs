package org.gmnz.ddi.algs.pq2;


import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;


public class TestMaxHeapPQ {

    @Test
    public void sample() {
        Assert.assertTrue(true);
    }



    @Test
    public void constructorTest() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(0);
        Assert.assertEquals(0, heap.size());
    }



    @Test
    public void constructorWrongTest() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(-2);
        Assert.assertEquals(0, heap.size());
        Assert.assertTrue(heap.isEmpty());
    }



    @Test
    public void constructorPathologicSizeTest() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(-1);
        Assert.assertEquals(0, heap.size());
        Assert.assertTrue(heap.isEmpty());
    }



    @Test
    public void testInsert() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(5);

        heap.insert(2);

        Assert.assertEquals(1, heap.size());
        Assert.assertFalse(heap.isEmpty());

        heap.insert(7);
        Assert.assertEquals(2, heap.size());
        Assert.assertFalse(heap.isEmpty());
    }



    @Test
    public void testDelMax() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(5);
        heap.insert(2);
        heap.insert(4);
        heap.insert(6);
        Assert.assertEquals(3, heap.size());

        Assert.assertEquals(Integer.valueOf(6), heap.delMax());
        Assert.assertEquals(2, heap.size());
    }



    @Test(expected = NoSuchElementException.class)
    public void testMaxWithEmptyHeap() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(5);
        heap.max();
    }



    @Test(expected = NoSuchElementException.class)
    public void testDelMaxWithEmptyHeap() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(5);
        heap.delMax();
    }



    @Test
    public void testWithFib() {
        int[] fibs = { 0, 1, 2, 3, 5, 8, 13, 21 };
        MaxHeapPQ<Integer> pq = new MaxHeapPQ<>(10);

        for (int f : fibs)
            pq.insert(f);

        Assert.assertEquals(fibs.length, pq.size());

        Assert.assertTrue(21 == pq.max());
        Assert.assertTrue(21 == pq.delMax());
        Assert.assertEquals(fibs.length-1, pq.size());
    }
}