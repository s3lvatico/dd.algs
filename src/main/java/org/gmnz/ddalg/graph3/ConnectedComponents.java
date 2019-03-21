package org.gmnz.ddalg.graph3;


import java.util.Collection;


/**
 * trovare i componenti connessi di un grafo è una specializzazione dell'analisi
 * dfs. L'idea è di condurre l'analisi dfs a partire da un vertice (anche
 * casuale, diciamo il primo), e dopo ogni analisi ripeterla finché esistono
 * vertici non visitati dalle analisi precedenti.
 *
 * @author gemini
 *
 */
public class ConnectedComponents {

	/**
	 * array indicizzato sui vertici che contiene l'identificativo del componente a
	 * cui il vertice appartiene
	 */
	private int[] id;

	/**
	 * questo contiene l'elenco dei vertici di cui è composto ogni componente
	 */
	private Collection<Integer>[] components;


	private boolean[] visited;

	private int componentId = 0;

	public ConnectedComponents(Graph g) {
		id = new int[g.countVertices()];
		components = new Collection[g.countVertices()];
		visited = new boolean[g.countVertices()];


	}

	private void dfs(Graph g, int vertex) {
		visited[vertex] = true;
		id[vertex] = componentId;
		for (int va : g.adjacencies(vertex)) {
			if (!visited[va]) {
				dfs(g, va);
			}
		}

	}
}
