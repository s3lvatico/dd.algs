package org.gmnz.ddi.algs.searching;

public class BinarySearchSymbolTable<K extends Comparable<K>, V> extends AbstractSortedSymbolTable<K, V> {

    private K[] k;
    private V[] v;
    private int n;

    @SuppressWarnings("unchecked")
    public BinarySearchSymbolTable(int capacity) {
        k = (K[]) new Comparable[capacity];
        v = (V[]) new Comparable[capacity];
        n = 0;
    }



    @Override
    public int size() {
        return n;
    }



    @Override
    public int rank(K key) {
        checkNullKey(key);

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = k[mid].compareTo(key);
            if (cmp < 0)
                hi = mid - 1;
            else
                if (cmp > 0)
                    lo = mid + 1;
                else
                    return mid;
        }
        return lo;
    }



    @Override
    public V get(K key) {
        if (isEmpty())
            return null;
        checkNullKey(key);
        int r = rank(key);
        if (r < n && k[r].equals(key))
            return v[r];
        else
            return null;
    }



    @Override
    public void put(K key, V value) {
        checkNullKey(key);
        if (n == k.length)
            throw new UnsupportedOperationException("table full");

    }



    @Override
    public K min() {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public K max() {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public K floor(K key) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public K ceiling(K key) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public K select(int r) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public Iterable<K> keys(K lo, K hi) {
        // TODO Auto-generated method stub
        return null;
    }

}
