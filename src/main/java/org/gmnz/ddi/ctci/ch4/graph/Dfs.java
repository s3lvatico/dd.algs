package org.gmnz.ddi.ctci.ch4.graph;


public class Dfs {

	private Graph g;
	private boolean[] visited;




	public Dfs(Graph g) {
		this.g = g;
		visited = new boolean[g.vertices()];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}




	public void dfsTraversal(int v) {
		if (visited[v]) {
			return;
		}
		visited[v] = true;
		System.out.format("%d ", v);
		for (int a : g.adjacencies(v)) {
			dfsTraversal(a);
		}
	}
}
