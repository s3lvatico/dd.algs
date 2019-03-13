package org.gmnz.ddalg.graph2;

class DfsClient {

	public static void main(String[] args) {
		System.out.println(SampleGraph.GRAPH);
		Dfs dfs = new Dfs(SampleGraph.GRAPH);
//		dfs.search(7);
		System.out.println(dfs.getPath(6, 9));
	}
}
