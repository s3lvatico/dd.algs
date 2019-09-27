package org.gmnz.ddi.algs.graph;


public class CycleFinderClient {

	public static void main(String[] args) {
		CycleFinder cf = new CycleFinder(Graph.GRAPH);
		System.out.println("grafo con ciclo? " + cf.hasCycle());
	}
}
