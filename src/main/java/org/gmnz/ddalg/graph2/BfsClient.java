package org.gmnz.ddalg.graph2;


class BfsClient {

	public static void main(String[] args) {
		System.out.println(SampleGraph.GRAPH);
		Bfs bfs = new Bfs(SampleGraph.GRAPH);
		bfs.search(2);
	}
}
