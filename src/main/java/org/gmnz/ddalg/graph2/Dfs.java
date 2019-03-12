package org.gmnz.ddalg.graph2;

import java.util.Arrays;

class Dfs {

	boolean[] visited;

	private Graph g;


	abstract class Visitor {
		abstract void visit();
	}

	Dfs(Graph g) {
		visited = new boolean[g.countVertices()];
		Arrays.fill(visited, false);
		this.g = g;
	}



	/**
	 * @param s
	 *             nodo di partenza (start!)
	 */
	void search(int s) {
		if (!g.hasNode(s)) {
			return;
		}

	}



	void dfs(int n) {
		if (visited[n]) {
			return;
		}
		new Visitor() {

			@Override
			void visit() {

			}

		}.visit();
		visited[n] = true;
		for(int x : g.adjacencies(n)) {
			dfs(x);
		}
	}

}
