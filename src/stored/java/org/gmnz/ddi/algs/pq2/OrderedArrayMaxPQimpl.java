package org.gmnz.ddi.algs.pq2;


/**
 * UnorderedArrayMaxPQimpl
 */
public class OrderedArrayMaxPQimpl<K extends Comparable<K>> extends ComparablesArrayManager<K> implements PriorityQueue<K> {

    private int n;

    @SuppressWarnings("unchecked")
    public OrderedArrayMaxPQimpl(int size) {
        v = (K[]) new Comparable[size];
        n = 0;
    }



    private boolean less(K x, K y) {
        return x.compareTo(y) < 0;
    }



    @Override
    public void insert(K key) {

        if (n == v.length)
            throw new UnsupportedOperationException("queue full");
        int i = n - 1;
        while (i >= 0 && less(key, v[i])) {
            v[i + 1] = v[i];
            i--;
        }
        v[i + 1] = key;
        n++;
    }



    @Override
    public K max() {
        if (isEmpty())
            return null;
        return v[n - 1];
    }



    @Override
    public K delMax() {
        if (isEmpty())
            return null;
        K maxKey = v[n - 1];
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