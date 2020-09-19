package org.gmnz.ddi.algs.foundation;

/**
 * Nodo per pile e code. Ha un valore di tipo parametrico e un riferimento a un
 * altro <code>Node</code>
 */
class Node<K> {

    /**
     * Chiave. Valore contenuto in questo nodo
     */
    K value;

    /**
     * L'unico nodo referenziato da questo nodo.
     */
    Node<K> next;

    /**
     * Crea un nuovo nodo con chiave e riferimento nulli
     */
    Node() {}



    /**
     * Crea un nuovo nodo con la chiave e il riferimento specificati
     * 
     * @param k
     * @param next
     */
    Node(K k, Node<K> next) {
        this.value = k;
        this.next = next;
    }



    /**
     * Crea un nuovo nodo con la chiave specificata e nessun riferimento ad altro
     * nodo
     * 
     * @param k
     */
    Node(K k) {
        this(k, null);
    }
}