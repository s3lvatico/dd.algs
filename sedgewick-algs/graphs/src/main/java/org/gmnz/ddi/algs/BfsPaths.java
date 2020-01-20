package org.gmnz.ddi.algs;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;


public class BfsPaths extends GraphPaths {

    private boolean[] marked;
    private int[] edgeTo;

    public BfsPaths(Graph g, int source) {
        super(g, source);
    }



    @Override
    protected void init() {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            marked[i] = false;
            edgeTo[i] = i;
        }
        bfs(source);
    }



    private void bfs(int v) {
        marked[v] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int w : g.adj(x))
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = x;
                    queue.add(w);
                }
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