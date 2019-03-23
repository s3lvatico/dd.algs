package org.gmnz.ddalg.graph3;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * La mia implementazione di grafo.
 * <p>
 * Questa classe modella un grafo non diretto e privo di anomalie. Se due
 * vertici sono connessi, allora esiste uno ed un solo arco tra loro; inoltre,
 * gli estremi di ogni arco sono sempre due vertici distinti.
 *
 * @author gemini
 *
 */
class Graph {

	/**
	 * mappa delle adiacenze
	 */
	private Map<Integer, Set<Integer>> adj;




	/**
	 * costruisce un nuovo grafo
	 */
	Graph() {
		adj = new HashMap<>();
	}




	/**
	 * aggiunge un nuovo vertice
	 *
	 * @param x
	 */
	void addVertex(int x) {
		if (!hasVertex(x)) {
			adj.put(x, new HashSet<Integer>());
		}
	}




	/**
	 * aggiung un nuovo sottografo.
	 * <p>
	 * Il sottografo inizia al primo elemento dell'array; i successivi elementi si
	 * intendono collegati con altrettanti archi al primo elemento
	 *
	 * @param vertexes
	 */
	void addSubgraph(int[] vertexes) {
		if (vertexes == null || vertexes.length == 0) {
			return;
		}
		addVertex(vertexes[0]);
		for (int i = 1; i < vertexes.length; i++) {
			addVertex(vertexes[i]);
			addEdge(vertexes[0], vertexes[i]);
		}
	}




	/**
	 * controlla se il vertice specificato esiste nel grafo
	 *
	 * @param x
	 * @return
	 */
	boolean hasVertex(int x) {
		return adj.containsKey(x);
	}




	/**
	 * collega i vertici specificati
	 *
	 * @param x
	 * @param y
	 */
	void addEdge(int x, int y) {
		adj.get(x).add(y);
		adj.get(y).add(x);
	}




	/**
	 * fornisce l'insieme dei vertici adiacenti al vertice specificato
	 *
	 * @param x
	 * @return
	 */
	Set<Integer> adjacencies(int x) {
		return adj.get(x);
	}




	/**
	 * fornisce il numero di vertici di questo grafo
	 *
	 * @return
	 */
	int countVertices() {
		return adj.size();
	}




	/**
	 * rimuove il vertice specificato dal grafo
	 *
	 * @param v
	 */
	void removeVertex(int v) {
		if (!hasVertex(v)) {
			return;
		}
		for (int x : adjacencies(v)) {
			adjacencies(x).remove(v);
		}
		adj.remove(v);
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Graph : " + countVertices() + " vertexes\n");
		for (int v : adj.keySet()) {
			builder.append(String.format("%4d", v)).append(" : ").append(adj.get(v)).append("\n");
		}
		return builder.toString();
	}

}
