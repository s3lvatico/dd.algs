package org.gmnz.ddi.algs;

public class CycleDetector {

    private boolean[] marked;
    private boolean hasCycle;

    public CycleDetector(Graph g) {
        marked = new boolean[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if (!marked[s]) 
                dfs(g, s, s);
        }
    }

    private void dfs(Graph g, int v, int u) {
        marked[v] = true;
        for (int w : g.adj(v))
            if (!marked[w])
                dfs(g, w, v);
            else
                if (w != u)
                    hasCycle = true;
    }

    public boolean hasCycle() { return hasCycle; }

}