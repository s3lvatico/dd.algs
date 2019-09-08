package org.gmnz.ddi.algs.pq2;

/**
 * AbstractPQ
 */
abstract class AbstractPQ<K extends Comparable<K>> {

    protected K[] pq;

    protected boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    void swap(int i, int j) {
        K temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}