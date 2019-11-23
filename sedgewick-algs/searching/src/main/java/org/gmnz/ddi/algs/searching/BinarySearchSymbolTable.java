package org.gmnz.ddi.algs.searching;


import java.util.HashSet;
import java.util.LinkedList;


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

        // int lo = 0;
        // int hi = n - 1;

        return rank(key, 0, n - 1);
        // sostituita la versione iterativa con quella ricorsiva
        /*
         * while (lo <= hi) { int mid = lo + (hi - lo) / 2; int cmp =
         * k[mid].compareTo(key); if (cmp < 0) hi = mid - 1; else if (cmp > 0) lo = mid
         * + 1; else return mid; } return lo;
         */ }



    private int rank(K key, int lo, int hi) {
        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(k[mid]);
            if (cmp < 0)
                return rank(key, lo, mid - 1);
            if (cmp > 0)
                return rank(key, mid + 1, hi);
            else
                return mid;
        }
        return lo;
    }



    @Override
    public V get(K key) {
        checkNullKey(key);
        if (isEmpty())
            return null;
        int r = rank(key);
        if (r < n && k[r].equals(key))
            return v[r];
        else
            return null;
    }



    @Override
    public void put(K key, V value) {
        checkNullKey(key);
        int r = rank(key);
        if (r < n && k[r].equals(key)) {
            v[r] = value;
            return;
        }
        if (n == k.length)
            throw new UnsupportedOperationException("table full");
        for (int i = n; i > r; i--) {
            k[i] = k[i - 1];
            v[i] = v[i - 1];
        }
        k[r] = key;
        v[r] = value;
        n++;
    }



    @Override
    public K min() {
        return k[0];
    }



    @Override
    public K max() {
        return k[n - 1];
    }



    @Override
    public K floor(K key) {
        checkNullKey(key);
        if (isEmpty())
            return null;
        int r = rank(key);
        if (contains(key))
            return k[r];
        if (r <= 0)
            return null;
        else
            return k[r - 1];
    }



    @Override
    public K ceiling(K key) {
        checkNullKey(key);
        int r = rank(key);
        if (r >= n)
            return null;
        else
            return k[r];
    }



    @Override
    public K select(int r) {
        if (0 <= r && r < n)
            return k[r];
        else
            throw new IllegalArgumentException();
    }



    @Override
    public Iterable<K> keys(K lo, K hi) {
        checkNullKey(lo);
        checkNullKey(hi);
        if (isEmpty())
            return new HashSet<>();
        LinkedList<K> keys = new LinkedList<>();
        for (int i = rank(lo); i < rank(hi); i++)
            keys.add(k[i]);
        if (contains(hi))
            keys.add(k[rank(hi)]);
        return keys;
    }

}
