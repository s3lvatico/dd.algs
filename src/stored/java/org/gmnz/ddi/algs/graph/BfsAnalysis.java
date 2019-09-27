package org.gmnz.ddi.algs.graph;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Queue;


/**
 * Breadth First analysis
 *
 * @author gemini
 *
 */
public class BfsAnalysis {

	/**
	 * indicizzato per vertice; durante l'analisi, indica quali vertici sono stati
	 * visitati
	 */
	private boolean[] visited;
	/**
	 * indicizzato per vertice; durante l'analisi, indica che un percorso dal
	 * vertice sorgente al vertice v passa per il vertice edgeTo[v]
	 */
	private int[] edgeTo;

	private int[] distanceTo;

	private final Graph g;

	private int sourceVertex;

	private Queue<Integer> queue;



	BfsAnalysis(Graph g, int sourceVertex) {
		this.g = g;
		this.sourceVertex = sourceVertex;
		visited = new boolean[g.countVertices()];
		edgeTo = new int[g.countVertices()];
		queue = new ArrayDeque<Integer>();
		distanceTo = new int[g.countVertices()];
		Arrays.fill(distanceTo, Integer.MAX_VALUE);
		bfs();
	}



	private void bfs() {
		// il vertice iniziale è visitato
		visited[sourceVertex] = true;
		// la sua distanza da esso stesso è naturalmente 0
		distanceTo[sourceVertex] = 0;
		// lo si aggiunge alla coda dei vertici
		queue.add(sourceVertex);
		while (!queue.isEmpty()) { // finché la coda dei vertici contiene elementi
			// recupera il prossimo vertice
			int v = queue.remove();
			// per ognuno dei vertici ad esso adiacenti
			for (int w : g.adjacencies(v)) {
				// se il vertice non è stato visitato
				if (!visited[w]) {
					// lo segna come visitato
					visited[w] = true;
					// aggiorna il contatore delle distanze
					distanceTo[w] = distanceTo[v] + 1;
					// aggiorna l'array dei percorsi impostando per il vertice corrente il vertice
					// da cui si proviene (che è quello per il quale si stanno analizzando le
					// adiacenze)
					edgeTo[w] = v;
					// aggiunge questo vertice alla coda di analisi
					queue.add(w);
				}
			}
		}
	}



	/**
	 * controllo dell'esistenza di un percorso dal vertice sorgente al vertice
	 * specificato
	 *
	 * @param v il vertice di arrivo
	 * @return <code>true</code> se esiste un percorso dal vertice sorgente al
	 *         vertice specificato, <code>false</code> altrimenti
	 */
	public boolean hasPathTo(int v) {
		return visited[v];
	}



	public Collection<Integer> pathTo(int v) {
		/*
		 * da documentazione dicono che convenga usare l'interfaccia DEQUE al posto
		 * dello STACK
		 */
		Deque<Integer> stack = new ArrayDeque<Integer>(edgeTo.length);
		for (int vp = v; vp != sourceVertex; vp = edgeTo[vp]) {
			stack.addFirst(vp);
		}
		stack.addFirst(sourceVertex);
		return stack;
	}



	public int distanceFromSource(int v) {
		return distanceTo[v];
	}

}
