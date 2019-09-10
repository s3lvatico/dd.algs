package org.gmnz.ddi.algs.pq2;


/**
 * UnorderedArrayMaxPQimpl
 */
public class OrderedArrayMaxPQimpl<K extends Comparable<K>> extends AbstractPQ<K> implements PriorityQueue<K> {

    private int n;

    @SuppressWarnings("unchecked")
    public OrderedArrayMaxPQimpl(int size) {
        pq = (K[]) new Comparable[size];
        n = 0;
    }



    private boolean less(K x, K y) {
        return x.compareTo(y) < 0;
    }



    @Override
    public void insert(K key) {

        if (n == pq.length)
            throw new UnsupportedOperationException("queue full");
        int i = n - 1;
        while (i >= 0 && less(key, pq[i])) {
            pq[i + 1] = pq[i];
            i--;
        }
        pq[i + 1] = key;
        n++;
    }



    @Override
    public K max() {
        if (isEmpty())
            return null;
        return pq[n - 1];
    }



    @Override
    public K delMax() {
        if (isEmpty())
            return null;
        K maxKey = pq[n - 1];
        n--;
        return maxKey;
    }



    @Override
    public int size() {
        return n;
    }



    @Override
    public boolean isEmpty() {
        return n == 0;
    }

}