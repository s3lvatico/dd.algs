package org.gmnz.ddalg.graph;


/**
 * dopo l'analisi determina se il grafo ha (almeno) un ciclo
 *
 * @author gemini
 *
 */
public class CycleFinder {

	private Graph g;

	private boolean[] visited;

	private boolean hasCycle;




	public CycleFinder(Graph g) {
		this.g = g;
		visited = new boolean[g.countVertices()];

		for (int s = 0; s < g.countVertices() - 1; s++) {
			if (!visited[s]) {
				dfs(s, s);
			}
		}
	}




	private void dfs(int v, int u) {
		System.out.format("dfs(%d, %d)%n", v, u);
		visited[v] = true;
		for (int w : g.adjacencies(v)) {
			if (!visited[w]) {
				dfs(w, v);
			}
			else
				if (w != u) {
					System.out.println("\tciclo trovato");
					hasCycle = true;
				}
		}
	}




	public boolean hasCycle() {
		return hasCycle;
	}


}
