package org.gmnz.ddi.algs.graph3;


/**
 * AbstractSearch
 */
public abstract class AbstractSearch implements Search {

    protected Graph g;
    protected int sourceVertex;

    public AbstractSearch(Graph g, int sourceVertex) {
        this.g = g;
        this.sourceVertex = sourceVertex;
    }
    
}