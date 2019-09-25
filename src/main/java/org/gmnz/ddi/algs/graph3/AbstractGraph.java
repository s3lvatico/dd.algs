package org.gmnz.ddi.algs.graph3;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


abstract class AbstractGraph implements Graph {

    protected int V;

    protected Map<Integer, List<Integer>> adjacencies;

    public AbstractGraph() {
        adjacencies = new HashMap<>();
    }


}