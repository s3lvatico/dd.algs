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



    /**
     * Controlla se una chive è nulla. Lancia {@link IllegalArgumentException} se la
     * chiave specificata è nulla.
     * <p>
     * Tipicamente questo metodo è usato ogniqualvolta si vuole compiere
     * un'operazione che ha una chiave come argomento.
     * 
     * @param key chiave da verificare
     * @throws IllegalArgumentException se la chiave specificata è nulla.
     */
    protected void checkNullKey(K key) {
        if (key == null)
            throw new IllegalArgumentException("null keys are not allowed");
    }
}