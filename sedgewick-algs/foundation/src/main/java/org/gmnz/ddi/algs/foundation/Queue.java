package org.gmnz.ddi.algs.foundation;

public interface Queue<K> {

    void insert(K k);

    K peek();

    K poll();

    int size();

}