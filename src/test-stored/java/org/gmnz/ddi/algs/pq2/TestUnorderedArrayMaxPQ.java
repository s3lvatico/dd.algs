package org.gmnz.ddi.algs.pq2;


import org.junit.Assert;
import org.junit.Test;


public class TestUnorderedArrayMaxPQ {

    @Test
    public void queueSize() {
        PriorityQueue<Integer> pq = PqFactory.newUnorderedArrayIntegerMaxPQ(0);
        Assert.assertTrue(pq.isEmpty());
        Assert.assertEquals(0, pq.size());
    }



    @Test(expected = UnsupportedOperationException.class)
    public void testFailingInsert() {
        PriorityQueue<Integer> pq = PqFactory.newUnorderedArrayIntegerMaxPQ(0);
        pq.insert(42);
    }



    @Test
    public void testMaxWithEmptyQ() {
        PriorityQueue<Integer> pq = PqFactory.newUnorderedArrayIntegerMaxPQ(0);
        Assert.assertNull(pq.delMax());
        Assert.assertNull(pq.max());
    }



    @Test
    public void testNotEmptyQ() {
        PriorityQueue<String> pq = new UnorderedArrayMaxPQimpl<>(3);
        pq.insert("b");
        pq.insert("c");
        pq.insert("a");

        Assert.assertEquals(3, pq.size());
        Assert.assertFalse(pq.isEmpty());

        Assert.assertEquals("c", pq.max());
        Assert.assertEquals("c", pq.delMax());
        Assert.assertEquals(2, pq.size());
    }



    @Test(expected = UnsupportedOperationException.class)
    public void testOverflow() {
        PriorityQueue<String> pq = new UnorderedArrayMaxPQimpl<>(2);
        pq.insert("b");
        pq.insert("c");
        pq.insert("a");
    }
}