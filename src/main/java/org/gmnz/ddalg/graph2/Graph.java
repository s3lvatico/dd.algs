package org.gmnz.ddalg.graph2;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class Graph {

	private Map<Integer, Set<Integer>> adj;



	Graph() {
		adj = new HashMap<>();
	}



	void add(int x) {
		if (!adj.containsKey(x)) {
			adj.put(x, new HashSet<Integer>());
		}
	}



	void addSubgraph(int[] nodes) {
		if (nodes == null || nodes.length == 0) {
			return;
		}
		int n = nodes[0];
		add(n);
		for (int i = 1; i < nodes.length; i++) {
			add(nodes[i]);
			connect(n, nodes[i]);
		}
	}



	void connect(int x, int y) {
		adj.get(x).add(y);
		adj.get(y).add(x);
	}



	Set<Integer> adjacencies(int x) {
		return adj.get(x);
	}



	public static void main(String[] args) {
		Graph g = new Graph();
		g.addSubgraph(new int[] { 0, 1, 2, 5, 6 });
		g.addSubgraph(new int[] { 3, 5, 4 });
		g.addSubgraph(new int[] { 4, 3, 5, 6 });
		g.addSubgraph(new int[] { 7, 8 });
		g.addSubgraph(new int[] { 9, 10, 11, 12 });
		g.addSubgraph(new int[] { 11, 12 });
	}
}
