package org.gmnz.ddi.ctci.ch4.graph;

import java.util.Collection;
import java.util.HashSet;

public class Graph {

	private int nEdges;
	private int nVertices;

	private Collection<Integer>[] adj;

	public Graph(int n) {
		nVertices = n;
		adj = new HashSet[n];

		for (int i = 0; i < n; i++) {
			adj[i] = new HashSet<Integer>();
		}
	}

	/*
	 * inizializziamolo con un array
	 */
	public void addEdge(int x, int y) {
		adj[x].add(y);
		adj[y].add(x);
		nEdges++;
	}

	public int edges() {
		return nEdges;
	}

	public int vertices() {
		return nVertices;
	}

	public Iterable<Integer> adjacencies(int vertex) {
		return adj[vertex];
	}

}
