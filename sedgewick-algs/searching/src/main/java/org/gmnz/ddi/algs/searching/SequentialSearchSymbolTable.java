package org.gmnz.ddi.algs.searching;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SequentialSearchSymbolTable<K, V> extends AbstractSymbolTable<K, V> {

    private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    Node first;

    @Override
    public void put(K key, V value) {
        checkNullKey(key);
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    @Override
    public V get(K key) {
        checkNullKey(key);
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key))
                return x.value;
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        // per come è definito delete, nella lista concatenata ci possono essere chiavi non nulle
        // cui corrispondono valori nulli. Tuttavia quelle chiavi non devono dare contributo alla
        // dimensione della ST, perciò bisogna controllare che, per ogni nodo, la chiave sia non
        // nulla (le chiavi nulle non sono nemmeno ammesse) e che il suo valore sia non nullo
        // (chiavi non nulle con valore nullo).
        for (Node x = first; x != null; x = x.next) {
            if (x.value != null)
                size++;
        }
        return size;
    }

    @Override
    public Iterable<K> keys() {
        if (size() == 0) {
            return Collections.emptySet();
        }
        Set<K> keys = new HashSet<>();
        for (Node x = first; x != null; x = x.next) {
            // l'insieme delle chiavi è ovviamente composto dalle chiavi che hanno un valore non
            // nullo
            if (x.value != null)
                keys.add(x.key);
        }
        return keys;
    }

}
