package org.gmnz.ddi.algs;

public class DepthFirstSearch extends Search {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int source) {
        super(g, source);
    }

    @Override
    protected void init() {
        marked = new boolean[g.V()];
        count = 0;
        dfs(g, source);
    }

    private void dfs(Graph g, int v) {
        if (marked(v))
            return;
        count++;
        marked[v] = true;
        for (int x : g.adj(v))
            dfs(g, x);
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