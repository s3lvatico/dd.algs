package org.gmnz.ddi.algs;

public class BreadthFirstSearch extends Search {

    private boolean[] marked;
    private int count;

    

    public BreadthFirstSearch(Graph g, int source) {
        super(g, source);
    }

    @Override
    protected void init() {
        marked = new boolean[g.V()];
        count = 0;
        bfs(g, source);
    }

    private void bfs(Graph g, int v) {
        
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }

}