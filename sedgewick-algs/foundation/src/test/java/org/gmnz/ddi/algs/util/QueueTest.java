package org.gmnz.ddi.algs.util;


import org.gmnz.ddi.algs.foundation.Queue;
import org.gmnz.ddi.algs.foundation.Queues;
import org.junit.Assert;
import org.junit.Test;


/**
 * QueueTest
 */
public class QueueTest {

    @Test
    public void createQueue() {
        Queue<Integer> q = Queues.createIntegerQueue();
        Assert.assertEquals(0, q.size());
        System.out.println(q);
    }



    @Test
    public void insertInQueue() {
        Queue<Integer> q = Queues.createIntegerQueue();
        Assert.assertEquals(0, q.size());
        q.insert(1);
        Assert.assertEquals(1, q.size());
        System.out.println(q);
        q.insert(0);
        Assert.assertEquals(2, q.size());
        System.out.println(q);
    }



    @Test
    public void peek() {
        Queue<Integer> q = Queues.createIntegerQueue();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        System.out.println(q);
        Assert.assertEquals(1, q.peek().intValue());

        Queue<Integer> q2 = Queues.createIntegerQueue();
        Assert.assertNull(q2.peek());
    }



    @Test
    public void poll() {
        Queue<Integer> q = Queues.createIntegerQueue();
        q.insert(1);
        q.insert(2);
        q.insert(3);

        Assert.assertEquals(1, q.poll().intValue());
        Assert.assertEquals(2, q.size());
        Assert.assertEquals(2, q.poll().intValue());
        Assert.assertEquals(1, q.size());
        Assert.assertEquals(3, q.poll().intValue());
        Assert.assertEquals(0, q.size());

        Assert.assertNull(q.peek());
        Assert.assertNull(q.poll());

    }
}