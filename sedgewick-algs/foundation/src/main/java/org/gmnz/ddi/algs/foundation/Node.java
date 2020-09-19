package org.gmnz.ddi.algs.foundation;

/**
 * Nodo per pile e code. Ha un valore di tipo parametrico e un riferimento a un
 * altro <code>Node</code>
 */
class Node<V> {

    /**
     * Valore contenuto in questo nodo
     */
    V value;

    /**
     * L'unico nodo referenziato da questo nodo.
     */
    Node<V> next;

    /**
     * Crea un nuovo nodo senza valore né riferimento esterno.
     */
    Node() {}



    /**
     * Crea un nuovo nodo con il valore e il riferimento specificati
     * 
     * @param v
     * @param next
     */
    Node(V v, Node<V> next) {
        this.value = v;
        this.next = next;
    }



    /**
     * Crea un nuovo nodo con il valore specificato e nessun riferimento ad altro
     * nodo
     * 
     * @param v
     */
    Node(V v) {
        this(v, null);
    }

}