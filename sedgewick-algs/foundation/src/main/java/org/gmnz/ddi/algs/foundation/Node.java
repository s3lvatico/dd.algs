package org.gmnz.ddi.algs.foundation;


/**
 * Nodo per pile e code
 */
class Node<K> {

    K value;
    Node<K> next;

    Node() {
    }



    Node(K k, Node<K> next) {
        this.value = k;
        this.next = next;
    }



    Node(K k) {
        this(k, null);
    }
}