package org.gmnz.ddi.algs;

public class BipartiteGraphChecker {

    private boolean[] marked;
    private boolean[] color;
    private boolean isBipartite = true;

    public BipartiteGraphChecker(Graph g) {
        marked = new boolean[g.V()];
        color = new boolean[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if (!marked[s]) {
                dfs(g, s);
            }
        }
    }



    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v))
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(g, w);
            } else
                if (color[w] == color[v])
                    isBipartite = false;
    }



    public boolean isBipartire() {
        return isBipartite;
    }

}