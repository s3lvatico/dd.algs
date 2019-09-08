package org.gmnz.ddi.algs.pq2;

/**
 * PqFactory
 */
public abstract class PqFactory {

    public static PriorityQueue<String> newUnorderedArrayStringMaxPQ(int size) {
        return new UnorderedArrayMaxPQimpl<String>(size);
    }

    public static PriorityQueue<Integer> newUnorderedArrayIntegerMaxPQ(int size) {
        return new UnorderedArrayMaxPQimpl<Integer>(size);
    }

}