package org.gmnz.ddi.algs.searching;

/**
 * Classica Symbol Table
 * 
 * @param <K> tipo della chiave
 * @param <V> tipo del valore associato alla chiave
 */
public interface SymbolTable<K, V> {
    
    void put(K key, V value);

    V get(K key);

    void delete(K key);

    boolean contains(K key);

    int size();

    boolean isEmpty();

    Iterable<K> keys();
}