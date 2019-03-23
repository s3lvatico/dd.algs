package org.gmnz.ddalg.graph;


public class DfsClient {



	public static void main(String[] args) {
		DfsAnalysis dfs = new DfsAnalysis(Graph.GRAPH, 4);
		System.out.println(dfs.pathTo(0));
	}

}
