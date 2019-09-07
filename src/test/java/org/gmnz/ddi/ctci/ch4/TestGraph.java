package org.gmnz.ddi.ctci.ch4;

import org.gmnz.ddi.ctci.ch4.graph.Graph;

public class TestGraph {

	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 3);

		System.out.printf("graph of [%d] vertieces and [%d] edges%n", g.vertices(), g.edges());

	}
}
