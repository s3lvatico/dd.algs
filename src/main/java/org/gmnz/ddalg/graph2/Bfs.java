package org.gmnz.ddalg.graph2;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


/**
 * breadth first search dato un grafo esistente.
 *
 * Non è una vera e propria ricerca di un vertice, ma un modo per stabilire
 * l'esistenza e la determinazione di percorsi specifici tra due vertici. In
 * particolare, se due vertici sono connessi, con la bfs si ottiene il percorso
 * più breve tra i due.
 * <p>
 * Sarebbe quindi più appropriato parlare di breadth first ANALYSIS. Una volta
 * analizzato il grafo si può interrogare la classe per conoscere i dettagli sui
 * percorsi tra i vertici.
 *
 * @author gemini
 *
 */
class Bfs {

	private final Graph g;


	private Queue<Integer> q;
	private boolean[] visited;
	private int[] edgeTo;
	private int[] distanceTo;



	Bfs(Graph g, int sourceVertex) {
		this.g = g;
		bfs(sourceVertex);
	}



	private void bfs(int v) {
		q = new LinkedList<>();
		visited = new boolean[g.countVertices()];
		Arrays.fill(visited, false);

		edgeTo = new int[g.countVertices()];

		distanceTo = new int[g.countVertices()];
		Arrays.fill(distanceTo, Integer.MAX_VALUE);

		distanceTo[v] = 0;
		visited[v] = true;
		q.add(v);

		while (!q.isEmpty()) {
			int x = q.remove();
			for (int w : g.adjacencies(x)) {
				if (!visited[w]) {
					edgeTo[w] = x;
					distanceTo[w] = distanceTo[x] + 1;
					visited[w] = true;
					q.add(w);
				}
			}
		}
	}



	boolean pathExists(int v, int w) {
		return visited[v] && visited[w];
	}



	Collection<Integer> getPath(int v, int w) {
		bfs(v);
		if (!pathExists(v, w)) {
			return null;
		}
		Deque<Integer> stack = new ArrayDeque<>();
		int x;
		for (x = w; distanceTo[x] != 0; x = edgeTo[x]) {
			stack.addFirst(x);
		}
		stack.addFirst(x);
		return stack;
	}

}
