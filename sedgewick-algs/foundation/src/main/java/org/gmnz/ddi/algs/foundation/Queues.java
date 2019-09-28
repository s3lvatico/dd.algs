package org.gmnz.ddi.algs.foundation;

/**
 * Queues
 */
public class Queues {

    public static Queue<Integer> createIntegerQueue() {
        return new QueueImpl<Integer>();
    }



    public static <K extends Comparable<K>> Queue<K> createComparableQueue() {
        return new QueueImpl<>();
    }
}