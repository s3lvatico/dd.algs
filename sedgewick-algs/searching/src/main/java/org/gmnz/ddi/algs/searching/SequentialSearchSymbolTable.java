package org.gmnz.ddi.algs.searching;

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
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key))
                return x.value;
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (Node x = first; x != null; x = x.next) {
            size++;
        }
        return size;
    }

    @Override
    public Iterable<K> keys() {
        Set<K> keys = new HashSet<>();
        for (Node x = first; x != null; x = x.next) {
            keys.add(x.key);
        }
        return keys;
    }

}