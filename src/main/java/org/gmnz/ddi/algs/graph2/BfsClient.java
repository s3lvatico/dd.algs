package org.gmnz.ddi.algs.graph2;


import java.util.Collection;


class BfsClient {

	public static void main(String[] args) {
		System.out.println(SampleGraph.GRAPH);
		BreadthFirst bfs = new BreadthFirst(SampleGraph.GRAPH, 0);
		System.out.println(bfs.pathExists(0, 4));
		System.out.println(bfs.pathExists(7, 9));

		Collection<Integer> path04 = bfs.getPath(0, 4);
		Collection<Integer> path1012 = bfs.getPath(10, 12);
		System.out.println(path04);
		System.out.println(path1012);

	}
}
