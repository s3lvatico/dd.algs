package org.gmnz.ddi.algs.foundation;


/**
 * Queues
 */
public class Queues {

    private Queues() {
    }



    public static Queue<Integer> createIntegerQueue() {
        return new QueueImpl<>();
    }



    public static <K extends Comparable<K>> Queue<K> createComparableQueue() {
        return new QueueImpl<>();
    }
}