package org.gmnz.ddi.algs;

abstract class GraphPaths {

    protected Graph g;
    protected int source;

    public GraphPaths(Graph g, int source) {
        this.g = g; this.source = source;
        init();
    }



    protected abstract void init();

    public abstract boolean hasPathTo(int v);

    public abstract Iterable<Integer> pathTo(int v);
}