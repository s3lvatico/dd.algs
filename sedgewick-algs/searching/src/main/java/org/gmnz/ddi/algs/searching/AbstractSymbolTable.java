package org.gmnz.ddi.algs.searching;

/**
 * Classe intermedia con implementazioni base di alcuni metodi.
 * 
 * @param <K> tipo di chiave
 * @param <V> tipo di valore
 */
abstract class AbstractSymbolTable<K, V> implements SymbolTable<K, V> {

    public void delete(K key) {
        put(key, null);
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}