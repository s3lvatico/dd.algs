package org.gmnz.ddi.algs.graph3;


/**
 * grafo non diretto
 */
public interface Graph {

    /**
     * @return numero di vertici
     */
    int V();

    /**
     * @return numero di archi
     */
    int E();

    /**
     * crea arco tra i vertici <code>x</code> e <code>y</code>
     */
    void edge(int x, int y);

    /**
     * vertici adiacenti a uno vertice specifico
     */
    Iterable<Integer> adj(int v);

    // TODO eventualmente aggiungi toString()
}