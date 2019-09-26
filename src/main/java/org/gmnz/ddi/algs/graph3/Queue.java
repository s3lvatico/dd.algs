package org.gmnz.ddi.algs.graph3;


interface Queue<K> {

    void insert(K k);
    K peek();
    K poll();

    int size();

}