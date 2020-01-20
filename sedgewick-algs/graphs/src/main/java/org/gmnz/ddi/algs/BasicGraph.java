package org.gmnz.ddi.algs;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

class BasicGraph implements Graph {

    private LinkedHashMap<Integer, List<Integer>> adjacencies;
    private int edges;

    BasicGraph(int v) {
        adjacencies = new LinkedHashMap<>(v);
        edges = 0;
    }

    @Override
    public int V() {
        return adjacencies.size();
    }

    @Override
    public int E() {
        return edges;
    }

    @Override
    public void addEdge(int v, int w) {
        createEdge(v, w);
        createEdge(w, v);
        edges++;
    }

    private void createEdge(int x, int y) {
        if (!adjacencies.containsKey(x))
            adjacencies.put(x, new LinkedList<>());
        adjacencies.get(x).add(y);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adjacencies.containsKey(v) ? adjacencies.get(v) : Collections.emptyList();
    }

}