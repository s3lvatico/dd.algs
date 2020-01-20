package org.gmnz.ddi.algs;


import java.util.ArrayDeque;
import java.util.Deque;


public class DfsPaths extends GraphPaths {

    private boolean[] marked;
    private int[] edgeTo;

    public DfsPaths(Graph g, int source) {
        super(g, source);
    }



    @Override
    protected void init() {
        marked = new boolean[g.V()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        edgeTo = new int[g.V()];
        dfs(source);
    }



    private void dfs(int v) {
        // se ho già visitato questo vertice, me ne vado
        if (marked[v])
            return;
        // marco il vertice come visitato
        marked[v] = true;
        for (int w : g.adj(v)) // per ogni vertice adiacente
            if (!marked[w]) { // se ancora non l'ho visitato
                // registro il collegamento
                edgeTo[w] = v;
                // proseguo in profondità
                dfs(w);
            }
    }



    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }



    @Override
    public Iterable<Integer> pathTo(int v) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int x = v; x != source; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(source);
        return stack;
    }


}