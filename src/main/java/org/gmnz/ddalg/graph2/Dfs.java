package org.gmnz.ddalg.graph2;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;


/**
 * depth first search
 * <p>
 * uso: inizializza con un grafo
 * <p>
 * {@link #search(int)} : attraversa il grafo in depth first
 * <p>
 * {@link #pathExists(int, int)} : dice se esiste o no un percorso tra due
 * vertici
 * <p>
 * {@link #getPath(int, int)} : ottiene il percorso tra due vertici, se esiste
 *
 */
class Dfs {

	// TODO da rivedere in funzione del concetto di ANALISI di un grafo

	/**
	 * il grafo da analizzare
	 */
	private Graph g;

	/**
	 * Durante l'attraversamento, viene impostato a <code>true</code> sull'indice
	 * che corrisponde all'id del nodo visitato.
	 * <p>
	 * <code>visited[v] = true</code> se durante un attraversamento ho visitato il
	 * vertice v.
	 */
	private boolean[] visited;
	private int[] edgeTo;




	Dfs(Graph g) {
		this.g = g;
	}




	void search(int s) {
		visited = new boolean[g.countVertices()];
		Arrays.fill(visited, false);
		edgeTo = new int[g.countVertices()];
		if (!g.hasVertex(s)) {
			return;
		}
		dfs(s);
	}




	/**
	 * depth first search vero e proprio
	 *
	 * @param v
	 *             vertice di partenza
	 */
	private void dfs(int v) {
		/* marca il vertice corrente come visitato */
		visited[v] = true;
		/* per ogni vertice adiacente al vertice corrente */
		for (int w : g.adjacencies(v)) {
			/* se non lo ho già visitato */
			if (!visited[w]) {
				/* dico che quel vertice adiacente è collegato al vertice che sto visitando */
				edgeTo[w] = v;
				/* visito il vertice adiacente */
				dfs(w);
			}
		}
	}




	/**
	 * Verifica se i vertici specificati sono connessi.
	 * <p>
	 * Indica, cioè, se esiste un percorso tra i vertici specificati.
	 *
	 * @param v
	 * @param w
	 * @return <code>true</code> se i vertici sono connessi, <code>false</code>
	 *         altrimenti
	 */
	boolean pathExists(int v, int w) {
		search(v);
		// dopo l'attraversamento dfs, i due vertici sono connessi se e solo se sono
		// stati visitati durante l'attraversamento
		return visited[v] && visited[w];
	}




	/**
	 * Ottiene il percorso che unisce i vertici specificati, se esiste.
	 *
	 * @param source
	 * @param dest
	 * @return una {@link Collection} con il percorso che unisce i due vertici, o
	 *         una {@link Collection} vuota se i vertici sono disgiunti
	 */
	Collection<Integer> getPath(int source, int dest) {
		// se non esiste un percorso tra i due vertici si restituisce una collezione
		// vuota
		if (!pathExists(source, dest)) {
			return new HashSet<Integer>();
		}

		// Inizializza uno stack che conterrà il percorso.
		// Perché stack? Perché parto dal vertice di destinazione, e uso l'array
		// edgeTo[] per tornare indietro verso il vertice iniziale.
		Deque<Integer> q = new ArrayDeque<Integer>();
		for (int i = dest; i != source; i = edgeTo[i]) {
			// attraversa l'array delle connessioni aggiungendo alla pila i vertici visitati
			q.addFirst(i);
		}
		// aggiunge l'ultimo vertice
		q.addFirst(source);
		return q;
	}
}
