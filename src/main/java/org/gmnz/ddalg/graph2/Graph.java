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



	void addNode(int x) {
		if (!adj.containsKey(x)) {
			adj.put(x, new HashSet<Integer>());
		}
	}



	void addSubgraph(int[] nodes) {
		if (nodes == null || nodes.length == 0) {
			return;
		}
		addNode(nodes[0]);
		for (int i = 1; i < nodes.length; i++) {
			addNode(nodes[i]);
			connect(nodes[0], nodes[i]);
		}
	}



	boolean hasNode(int x) {
		return adj.containsKey(x);
	}



	void connect(int x, int y) {
		adj.get(x).add(y);
		adj.get(y).add(x);
	}



	void removeNode(int node) {
		if (!hasNode(node)) {
			return;
		}
		for (int x : adjacencies(node)) {
			adjacencies(x).remove(node);
		}
		adj.remove(node);
	}



	Set<Integer> adjacencies(int x) {
		return adj.get(x);
	}



	int countVertices() {
		return adj.size();
	}



	public static void main(String[] args) {
		Graph g = new Graph();
		g.addSubgraph(new int[] { 0, 1, 2, 5, 6 });
		g.addSubgraph(new int[] { 3, 5, 4 });
		g.addSubgraph(new int[] { 4, 3, 5, 6 });
		g.addSubgraph(new int[] { 7, 8 });
		g.addSubgraph(new int[] { 9, 10, 11, 12 });
		g.addSubgraph(new int[] { 11, 12 });

		g.removeNode(4);
	}
}
