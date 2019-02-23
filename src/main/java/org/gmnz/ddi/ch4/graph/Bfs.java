package org.gmnz.ddi.ch4.graph;


import java.util.LinkedList;
import java.util.Queue;


public class Bfs {

	private Graph g;
	private boolean[] visited;



	public Bfs(Graph g) {
		this.g = g;
		visited = new boolean[g.vertices()];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}



	public void bfs(int v) {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		bfsTraversal(v);
	}



	protected void bfsTraversal(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		System.out.format("%d ", v);
		visited[v] = true;
		q.add(v);
		while (!q.isEmpty()) {
			int k = q.remove();
			for (int w : g.adjacencies(k)) {
				if (!visited[w]) {
					System.out.format("%d ", w);
					visited[w] = true;
					q.add(w);
				}
			}
		}
	}
}
