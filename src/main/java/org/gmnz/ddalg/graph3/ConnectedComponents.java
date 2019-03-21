package org.gmnz.ddalg.graph3;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

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

	/**
	 * 
	 */
	private boolean[] visited;

	/**
	 * 
	 */
	private int componentId = 0;

	/**
	 * @param g
	 */
	@SuppressWarnings("unchecked")
	public ConnectedComponents(Graph g) {
		id = new int[g.countVertices()];
		components = new Collection[g.countVertices()];
		visited = new boolean[g.countVertices()];
		/*
		 * attenzione all'uso del metodo Arrays.fill(...).
		 * 
		 * Questo enunciato genera un brutto errore logico. Non pensare che ogni
		 * posizione dell'array venga riempita con un nuovo insieme (vuoto). In realtà
		 * il metodo fill valorizza il contenuto dell'array con LO STESSO IDENTICO
		 * valore specificato. In questo caso tutto l'array viene inizializzato con un
		 * puntatore al MEDESIMO insieme.
		 */
		// Arrays.fill(components, new HashSet<Integer>());
		for (int i = 0; i < components.length; i++) {
			components[i] = new HashSet<Integer>();
		}

		for (int v = 0; v < g.countVertices(); v++) {
			if (!visited[v]) {
				dfs(g, v);
				componentId++;
			}
		}
	}

	private void dfs(Graph g, int vertex) {
		id[vertex] = componentId;
		components[componentId].add(vertex);
		visited[vertex] = true;
		for (int va : g.adjacencies(vertex)) {
			if (!visited[va]) {
				dfs(g, va);
			}
		}
	}

	void printComponents() {
		System.out.format("graph made of %d connected components%n", componentId + 1);
		for (int i = 0; i < components.length; i++) {
			if (!components[i].isEmpty()) {
				System.out.printf("id: %d | %s%n", i, components[i]);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ConnectedComponents cc = new ConnectedComponents(ClientDfs.GRAPH);
		cc.printComponents();
	}
}
