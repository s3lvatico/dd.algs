package org.gmnz.ddalg.graph2;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Bfs {

	private final Graph g;

	private Queue<Integer> q;
	private boolean[] visited;
	private int[] edgeTo;



	Bfs(Graph g) {
		this.g = g;
	}



	void search(int v) {
		q = new LinkedList<>();
		visited = new boolean[g.countVertices()];
		Arrays.fill(visited, false);
		edgeTo = new int[g.countVertices()];

		visited[v] = true;
		q.add(v);

		while (!q.isEmpty()) {
			int x = q.remove();
			for (int w : g.adjacencies(x)) {
				if (!visited[w]) {
					edgeTo[w] = x;
					visited[w] = true;
					q.add(w);
				}
			}
		}
	}
}
