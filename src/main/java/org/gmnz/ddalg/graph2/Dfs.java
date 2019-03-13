package org.gmnz.ddalg.graph2;

import java.util.Arrays;

class Dfs {

	boolean[] visited;

	private Graph g;

	Dfs(Graph g) {
		visited = new boolean[g.countVertices()];
		Arrays.fill(visited, false);
		this.g = g;
	}

	/**
	 * @param s nodo di partenza (start!)
	 */
	void search(int s) {
		if (!g.hasNode(s)) {
			return;
		}
	}

	private void dfs(int n) {
		if (visited[n]) {
			return;
		}
		System.out.println(n);
		visited[n] = true;
		for (int x : g.adjacencies(n)) {
			dfs(x);
		}
	}

	public static void main(String[] args) {
		System.out.println(SampleGraph.GRAPH);
		Dfs dfs = new Dfs(SampleGraph.GRAPH);
		dfs.dfs(6);
	}
}
