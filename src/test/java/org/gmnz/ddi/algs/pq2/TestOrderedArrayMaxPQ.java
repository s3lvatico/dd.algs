package org.gmnz.ddi.algs.pq2;


import org.junit.Assert;
import org.junit.Test;


public class TestOrderedArrayMaxPQ {

    @Test
    public void queueSize() {
        PriorityQueue<Integer> pq = new OrderedArrayMaxPQimpl<>(0);
        Assert.assertTrue(pq.isEmpty());
        Assert.assertEquals(0, pq.size());
    }



    @Test(expected = UnsupportedOperationException.class)
    public void testFailingInsert() {
        PriorityQueue<Integer> pq = new OrderedArrayMaxPQimpl<>(0);
        pq.insert(42);
    }



    @Test
    public void testMaxWithEmptyQ() {
        PriorityQueue<Integer> pq = new OrderedArrayMaxPQimpl<>(0);
        Assert.assertNull(pq.delMax());
        Assert.assertNull(pq.max());
    }



    @Test
    public void testNotEmptyQ() {
        PriorityQueue<String> pq = new OrderedArrayMaxPQimpl<>(4);
        pq.insert("b");
        pq.insert("d");
        pq.insert("c");
        pq.insert("a");

        Assert.assertEquals(4, pq.size());
        Assert.assertFalse(pq.isEmpty());

        Assert.assertEquals("d", pq.max());
        Assert.assertEquals("d", pq.delMax());
        Assert.assertEquals(3, pq.size());
    }



    @Test(expected = UnsupportedOperationException.class)
    public void testOverflow() {
        PriorityQueue<String> pq = new OrderedArrayMaxPQimpl<>(2);
        pq.insert("b");
        pq.insert("c");
        pq.insert("a");
    }
}