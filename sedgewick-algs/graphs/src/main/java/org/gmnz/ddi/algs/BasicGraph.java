package org.gmnz.ddi.algs;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

class BasicGraph implements Graph {

    private LinkedHashMap<Integer, List<Integer>> adjacencies;

    BasicGraph(int v) {
        adjacencies = new LinkedHashMap<>(v);
    }

    @Override
    public int V() {
        return adjacencies.size();
    }

    @Override
    public int E() {
        int edges = 0;
        for (Integer v : adjacencies.keySet())
            edges += adjacencies.get(v).size();
        return edges;
    }

    @Override
    public void addEdge(int v, int w) {
        createEdge(v, w);
        createEdge(w, v);
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