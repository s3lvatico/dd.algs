package org.gmnz.ddi.algs;

abstract class Search {

    protected Graph g;
    protected int source;

    public Search(Graph g, int source) {
        this.g = g;
        this.source = source;
        init();
    }

    /**
     * inizializza l'algoritmo di ricerca. A questo livello la classe ha già
     * disponibili sia il grafo sia il vertice di partenza
     */
    protected abstract void init();

    /**
     * 
     */
    public abstract boolean marked(int v);

    /**
     * quanti vertici sono connessi al vertice iniziale
     */
    public abstract int count();
}