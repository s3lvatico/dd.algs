package org.gmnz.ddi.algs;


public abstract class ConnectedComponents {

    protected Graph g;

    public ConnectedComponents(Graph g) {
        this.g = g;
        init();
    }



    protected abstract void init();

    /**
     * controlla se i due vertici dati sono connessi tra loro
     */
    public abstract boolean connected(int v, int w);

    /**
     * numero di componenti connessi in questo grafo
     */
    public abstract int count();

    /**
     * identificativo del componente a cui il vertice specificato appartiene
     * 
     * @param  v
     * @return
     */
    public abstract int id(int v);


}