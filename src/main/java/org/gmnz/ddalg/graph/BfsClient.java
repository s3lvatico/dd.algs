package org.gmnz.ddalg.graph;


public class BfsClient {

	public static void main(String[] args) {
		BfsAnalysis bfs = new BfsAnalysis(Graph.GRAPH, 10);
		System.out.println(bfs.pathTo(12));
		bfs = new BfsAnalysis(Graph.GRAPH, 4);
		System.out.println(bfs.pathTo(0));
		System.out.println("distance from source: " + bfs.distanceFromSource(0));
	}

}
