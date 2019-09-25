package org.gmnz.ddi.algs.graph3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class BasicGraph extends AbstractGraph {

    private int nEdges;

    private Consumer<Integer> checkMapKey = (x) -> {
        if (!adjacencies.containsKey(x)) {
            adjacencies.put(x, new ArrayList<>());
        }
    };

    private BiConsumer<Integer, Integer> checkKeyPair = (x, y) -> {
        checkMapKey.accept(x);
        checkMapKey.accept(y);
    };

    public BasicGraph(Scanner s) {
        int nVertexes = s.nextInt();
        adjacencies = new HashMap<>(nVertexes);
        nEdges = s.nextInt();
        for (int i = 0; i < nEdges; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            edge(x, y);
        }
    }



    @Override
    public int V() {
        return adjacencies.size();
    }



    @Override
    public int E() {
        return nEdges;
    }



    @Override
    public void edge(int x, int y) {
        checkKeyPair.accept(x, y);
        adjacencies.get(x).add(y);
        adjacencies.get(y).add(x);
    }



    @Override
    public Iterable<Integer> adj(int v) {
        return adjacencies.get(v);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V: %d | E: %d%n", V, nEdges));
        for (Map.Entry<Integer, List<Integer>> entry : adjacencies.entrySet()) {
            sb.append(String.format("%d : ", entry.getKey()));
            for (int x : entry.getValue()) {
                sb.append(String.format("%4d", x));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}