package org.gmnz.ddalg.graph3;


public class ClientDfs {

	static final Graph GRAPH;

	static {
		GRAPH = new Graph();
		GRAPH.addSubgraph(new int[] { 0, 1, 2, 5, 6 });
		GRAPH.addSubgraph(new int[] { 3, 5, 4 });
		GRAPH.addSubgraph(new int[] { 4, 3, 5, 6 });
		GRAPH.addSubgraph(new int[] { 7, 8 });
		GRAPH.addSubgraph(new int[] { 9, 10, 11, 12 });
		GRAPH.addSubgraph(new int[] { 11, 12 });
	}




	public static void main(String[] args) {
		DfsAnalysis dfs = new DfsAnalysis(GRAPH, 4);
		System.out.println(dfs.pathTo(0));

	}

}
