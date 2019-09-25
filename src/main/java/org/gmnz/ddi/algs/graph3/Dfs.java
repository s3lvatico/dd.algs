package org.gmnz.ddi.algs.graph3;


import java.util.Arrays;


/**
 * Dfs
 */
public class Dfs extends AbstractSearch {

    private boolean[] marked;
    private int count;

    public Dfs(Graph g, int sourceVertex) {
        super(g, sourceVertex);
        marked = new boolean[g.V()];
        Arrays.fill(marked, false);
        count = 0;
        dfs(sourceVertex);
    }



    private void dfs(int s) {
        count++;
        marked[s] = true;
        for (int v : g.adj(s)) {
            if (!marked(v)) {
                dfs(v);
            }
        }
    }



    @Override
    public int count() {
        return count;
    }



    @Override
    public boolean marked(int v) {
        return marked[v];
    }


}