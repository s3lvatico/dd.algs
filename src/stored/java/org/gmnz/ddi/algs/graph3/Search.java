package org.gmnz.ddi.algs.graph3;


/**
 * Base per le ricerche in un grafo
 */
public interface Search {

    /**
     * quanti vertici sono connesi ad un determinato vertice?
     */
    int count();



    /**
     * controlla se uno specifico vertice è stato visitato
     * 
     * @param  v vertice del grafo
     * @return   <code>t/f</code>
     */
    boolean marked(int v);
    
}