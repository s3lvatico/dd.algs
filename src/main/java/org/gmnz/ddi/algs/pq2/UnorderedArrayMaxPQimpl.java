package org.gmnz.ddi.algs.pq2;

/**
 * UnorderedArrayMaxPQimpl
 */
public class UnorderedArrayMaxPQimpl<K extends Comparable<K>> extends AbstractPQ<K> implements PriorityQueue<K> {

    private int n;

    public UnorderedArrayMaxPQimpl(int size) {
        pq = (K[]) new Comparable[size];
        n = 0;
    }

    @Override
    public void insert(K key) {
        if (n == pq.length)
            throw new UnsupportedOperationException("queue full");
        pq[n++] = key;
    }

    @Override
    public K max() {
        if (isEmpty())
            return null;
        int max = getMaxIndex();
        return pq[max];
    }

    @Override
    public K delMax() {
        if (isEmpty())
            return null;
        int max = getMaxIndex();
        K maxKey = pq[max];
        pq[max] = pq[--n];
        return maxKey;
    }

    private int getMaxIndex() {
        int i = 0;
        int max = i;
        while (i < n) {
            if (less(max, i))
                max = i;
            i++;
        }
        return max;
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