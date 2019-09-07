package org.gmnz.ddi.algs.graph2;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Grafo diretto
 */
public class DiGraph {

	private Map<Integer, Set<Integer>> adj;




	public DiGraph() {
		adj = new HashMap<>();
	}




	public int addVertex(int v) {
		if (!adj.containsKey(v)) {
			adj.put(v, new HashSet<>());
		}
		return adj.size();
	}




	public void addDirectedEdge(int from, int to) {
		addVertex(from);
		addVertex(to);
		adj.get(from).add(to);
	}




	/**
	 * fornisce l'insieme dei vertici adiacenti al vertice specificato
	 *
	 * @param x
	 * @return
	 */
	public Set<Integer> adjacencies(int x) {
		return adj.get(x);
	}




	public int countVertices() {
		return adj.size();
	}

}
