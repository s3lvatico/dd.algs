package org.gmnz.ddi.algs;


import java.util.Collection;
import java.util.LinkedList;


public class BreadthFirstSearch extends Search {

    private boolean[] marked;
    private int count;

    /*
     * questa funziona come una coda
     */
    private LinkedList<Integer> queue;

    public BreadthFirstSearch(Graph g, int source) {
        super(g, source);
    }



    @Override
    protected void init() {
        marked = new boolean[g.V()];
        count = 0;
        queue = new LinkedList<>();
        bfs(g, source);
    }



    private void bfs(Graph g, int v) {
        marked[v] = true;
        count++;
        queue.addAll((Collection<? extends Integer>) g.adj(v));
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (!marked(x)) {
                marked[x] = true;
                count++;
                queue.addAll((Collection<? extends Integer>) g.adj(x));
            }
        }
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