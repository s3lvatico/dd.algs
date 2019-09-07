package org.gmnz.ddi.algs.pq2;

/**
 * PriorityQueue
 */
public interface PriorityQueue<K extends Comparable<K>> {

    void insert(K key);

    K max();

    K delMax();

    int size();

    boolean isEmpty();

}