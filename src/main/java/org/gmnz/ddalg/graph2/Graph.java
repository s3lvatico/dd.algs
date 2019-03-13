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
			addEdge(nodes[0], nodes[i]);
		}
	}

	boolean hasNode(int x) {
		return adj.containsKey(x);
	}

	void addEdge(int x, int y) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Graph : " + countVertices() + " vertices\n");
		for (int node : adj.keySet()) {
			builder.append(String.format("%4d", node)).append(" : ").append(adj.get(node)).append("\n");
		}
		return builder.toString();
	}

}
