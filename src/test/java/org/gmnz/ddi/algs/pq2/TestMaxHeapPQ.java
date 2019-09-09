package org.gmnz.ddi.algs.pq2;


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



    public void testDelMax() {
        MaxHeapPQ<Integer> heap = new MaxHeapPQ<>(5);
        heap.insert(2);
        heap.insert(4);
        heap.insert(6);
        Assert.assertEquals(3, heap.size());

        Assert.assertEquals(Integer.valueOf(6), heap.delMax());
        Assert.assertEquals(2, heap.size());
    }
}