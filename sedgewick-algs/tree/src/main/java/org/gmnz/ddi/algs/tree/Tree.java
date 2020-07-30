package org.gmnz.ddi.algs.tree;

public interface Tree<K extends Comparable<K>, V> {

   int size();

   V get(K key);

   void put(K key, V value);

}