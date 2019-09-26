package org.gmnz.ddi.algs.graph3;


import java.util.Arrays;


/**
 * Bfs
 */
public class Bfs extends AbstractSearch {

    private int count;

    private boolean[] marked;

    public Bfs(Graph g, int sourceVertex) {
        super(g, sourceVertex);
        count = 0;
        marked = new boolean[g.V()];
        Arrays.fill(marked, false);
        bfs(sourceVertex);
    }



    private void bfs(int source) {
        int v = source;
        Queue<Integer> queue = new BasicQueue<>();
        queue.insert(v);

        // count++;

        while (queue.size() != 0) {
            int w = queue.poll();
            if (!marked[w]) {
                count++;
                for (int x : g.adj(w)) {
                    queue.insert(x);
                }
                marked[w] = true;
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