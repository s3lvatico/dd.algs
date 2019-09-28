package org.gmnz.ddi.algs.foundation;

/**
 * Stack
 */
public interface Stack<K> {

    void push(K k);

    K pop();

    int size();

}