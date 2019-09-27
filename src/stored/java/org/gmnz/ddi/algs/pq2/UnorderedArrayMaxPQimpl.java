package org.gmnz.ddi.algs.pq2;


/**
 * UnorderedArrayMaxPQimpl
 */
public class UnorderedArrayMaxPQimpl<K extends Comparable<K>> extends ComparablesArrayManager<K> implements PriorityQueue<K> {

    private int n;

    @SuppressWarnings("unchecked")
    public UnorderedArrayMaxPQimpl(int size) {
        v = (K[]) new Comparable[size];
        n = 0;
    }



    @Override
    public void insert(K key) {
        if (n == v.length)
            throw new UnsupportedOperationException("queue full");
        v[n++] = key;
    }



    @Override
    public K max() {
        if (isEmpty())
            return null;
        int max = getMaxIndex();
        return v[max];
    }



    @Override
    public K delMax() {
        if (isEmpty())
            return null;
        int max = getMaxIndex();
        K maxKey = v[max];
        v[max] = v[--n];
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