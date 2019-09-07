package org.gmnz.ddi.algs.graph;


public class BiPartiteCheck {

	/*
	 * controlla la proprietà di bipartizione.
	 *
	 * Bipartizione: esiste una partizione dell'insieme dei vertici tale gli estremi
	 * di ogni arco appartengono a due insiemi disgiunti.
	 *
	 * E' anche chiamata "colorabilità-a-2", "two-colorability"
	 */

	private Graph g;
	private boolean[] visited;
	private boolean[] color;

	private boolean isBipartite = true;




	public BiPartiteCheck(Graph g) {
		visited = new boolean[g.countVertices()];
		color = new boolean[g.countVertices()];
		for (int v = 0; v < g.countVertices(); v++) {
			if (!visited[v]) {
				dfs(v);
			}
		}
	}




	private void dfs(int v) {
		visited[v] = true;
		for (int w : g.adjacencies(v)) {
			if (!visited[w]) {
				color[w] = !color[v];
				dfs(w);
			}
			else {
				isBipartite = color[v] ^ color[w];
			}
		}

	}




	public boolean isBipartite() {
		return isBipartite;
	}




	public static void main(String[] args) {

	}
}
