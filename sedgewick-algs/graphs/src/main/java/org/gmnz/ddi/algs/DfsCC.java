package org.gmnz.ddi.algs;


import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;


public class DfsCC extends ConnectedComponents {

    private int[] componentId;
    private boolean[] marked;
    private int[] edgeTo;
    private int numComponents;

    public DfsCC(Graph g) {
        super(g);
    }



    @Override
    protected void init() {
        numComponents = 0;

        componentId = new int[g.V()];
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];

        for (int i = 0; i < g.V(); i++) {
            componentId[i] = i;
            edgeTo[i] = i;
            marked[i] = false;
        }
        dfs();
    }



    private void dfs() {
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(i);
                numComponents++;
            }
        }
    }



    private void dfs(int v) {
        if (marked[v])
            return;

        marked[v] = true;
        componentId[v] = numComponents;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(w);
            }
        }
    }



    @Override
    public boolean connected(int v, int w) {
        return componentId[v] == componentId[w];
    }



    @Override
    public int count() {
        return numComponents;
    }



    @Override
    public int id(int v) {
        return componentId[v];
    }



    public Collection<Integer> findPath(int v, int w) {
        if (!connected(v, w))
            return null;
        Deque<Integer> stack = new ArrayDeque<>();

        // tenta prima la via v --> w
        int i = v;
        stack.push(i);
        boolean pathFound = false;
        while (edgeTo[i] != i && !pathFound) {
            i = edgeTo[i];
            stack.push(i);
            if (i == w)
                pathFound = true;
        }
        if (!pathFound) {
            stack.clear();
            i = w;
            stack.push(i);
            while (edgeTo[i] != i && !pathFound) {
                i = edgeTo[i];
                stack.push(i);
                if (i == w)
                    pathFound = true;
            }
        }

        return stack;
    }

}