package org.gmnz.ddi.algs;


abstract class GraphPaths {

    protected Graph g;
    protected int source;

    public GraphPaths(Graph g, int source) {
        this.g = g;
        this.source = source;
        init();
    }



    protected abstract void init();

    /**
     * dice se esiste un percorso che unisce il vertice sorgente al vertice dato
     */
    public abstract boolean hasPathTo(int v);

    /**
     * Ottiene il percorso dal vertice sorgente al vertice dato, oppure null se i
     * due vertici non sono connessi
     */
    public abstract Iterable<Integer> pathTo(int v);
}