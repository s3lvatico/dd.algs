package org.gmnz.ddalg.graph;


import java.util.ArrayDeque;
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

	private final Graph g;

	private int sourceVertex;


	private Queue<Integer> queue;


	BfsAnalysis(Graph g, int sourceVertex) {
		this.g = g;
		this.sourceVertex = sourceVertex;
		visited = new boolean[g.countVertices()];
		edgeTo = new int[g.countVertices()];
		queue = new ArrayDeque<Integer>();
		bfs();
	}




	private void bfs() {
		visited[sourceVertex] = true;
		queue.add(sourceVertex);
		while(!queue.isEmpty()) {
			int v = queue.remove();
			for (int w : g.adjacencies(v)) {
				if (!visited[w]) {
					visited[w] = true;
					edgeTo[w] = v;
					queue.add(w);
				}
			}
		}
	}




	/**
	 * controllo dell'esistenza di un percorso dal vertice sorgente al vertice
	 * specificato
	 *
	 * @param v
	 *             il vertice di arrivo
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

}
