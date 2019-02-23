package org.gmnz.ddi.ch4.graph;


import java.util.LinkedList;
import java.util.Queue;


/**
 * Breath First Search in un grafo.
 *
 * Nota la differenza: DFS è ricorsivo, mentre BFS è iterativo.
 *
 * @author gemini
 *
 */
public class Bfs {

	private Graph g;
	/**
	 * tiene conto dei nodi che sono già stati visitati
	 */
	private boolean[] visited;



	public Bfs(Graph g) {
		this.g = g;

		// inizializza l'array dei nodi visitati
		visited = new boolean[g.vertices()];
	}



	public void bfs(int v) {
		// inizialmente tutti i nodi non sono stati visitati
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		bfsTraversal(v);
	}



	/**
	 * Visita in bfs il grafo.
	 * <p>
	 * In questa implementazione la visita di un nodo consiste solo nel
	 * visualizzarlo.
	 * <p>
	 * Il procedimento è di mettere in coda un nodo appena visitato e di elaborare
	 * ogni nodo in uscita dalla coda visitando tutti i nodi ad esso adiacenti.
	 *
	 * @param v
	 */
	protected void bfsTraversal(int v) {
		// inizializza la coda dei nodi adiacenti
		Queue<Integer> q = new LinkedList<Integer>();

		// visita il nodo
		System.out.format("%d ", v);

		// marca il nodo come visitato
		visited[v] = true;

		// aggiunge il nodo alla coda
		q.add(v);

		// finché ci sono nodi visitati le cui adiacenze vanno controllate
		while (!q.isEmpty()) {
			// recupera il nodo dalla coda
			int k = q.remove();
			// considera tutte i nodi ad esso adiacenti
			for (int w : g.adjacencies(k)) {
				if (!visited[w]) {
					// se il nodo (adiacente a quello in esame) non è stato visitato, lo visita...
					System.out.format("%d ", w);
					visited[w] = true;
					// .. e lo accoda, in modo che definitivamente verranno considerati i nodi ad
					// esso adiacenti
					q.add(w);
				}
			}
		}
		System.out.println();
	}
}
