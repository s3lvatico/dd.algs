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

	/**
	 * occhio che questa è da rivedere
	 * @param nodes
	 */
	void addSubgraph(int[] nodes) {
		for (int i =0; i< nodes.length; i++) {
			for (int j=i+1; j<nodes.length; j++) {
				add(nodes[i]);
				add(nodes[j]);
				connect(nodes[i], nodes[j]);
			}
		}
	}

	void connect(int x, int y) {
		adj.get(x).add(y);
		adj.get(y).add(x);
	}

	private Set<Integer> adjacencies(int x) {
		return adj.get(x);
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addSubgraph(new int[] {0, 1, 2, 5, 6});
		g.addSubgraph(new int[] {3, 5, 4});
		g.addSubgraph(new int[] {4, 6});
		g.addSubgraph(new int[] {7,8});
		g.addSubgraph(new int[] {9, 10, 11, 12});
	}
}
