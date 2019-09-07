package org.gmnz.ddi.algs.graph2;


final class SampleGraph {

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

}
