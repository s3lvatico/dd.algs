package org.gmnz.ddi.algs.searching;


import java.util.HashSet;


abstract class AbstractSortedSymbolTable<K extends Comparable<K>, V> extends AbstractSymbolTable<K, V>
        implements SortedSymbolTable<K, V> {

    public void deleteMin() {
        delete(min());
    }



    public void deleteMax() {
        delete(max());
    }



    public int size(K lo, K hi) {
        checkNullKey(lo);
        checkNullKey(hi);
        if (hi.compareTo(lo) < 0)
            return 0;
        if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }



    public Iterable<K> keys() {
        if (isEmpty())
            return new HashSet<>();
        return keys(min(), max());
    }
}