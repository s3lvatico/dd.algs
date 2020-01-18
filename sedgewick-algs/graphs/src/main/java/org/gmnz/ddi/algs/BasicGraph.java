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
        if (!adjacencies.containsKey(v))
            adjacencies.put(v, new LinkedList<>());
        adjacencies.get(v).add(w);
    }



    @Override
    public Iterable<Integer> adj(int v) {
        return adjacencies.containsKey(v) ? adjacencies.get(v) : Collections.emptyList();
    }

}