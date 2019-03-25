package org.gmnz.ddalg.graph;


/**
 * durante l'analisi determina se il grafo ha (almeno) un ciclo
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




	/**
	 * attraversamento dfs per determinare la presenza di almeno un ciclo.
	 * <p>
	 * il metodo non determina il numero di cicli, ma solo l'esistenza di un ciclo.
	 * <p>
	 * Questa versione del dfs è modificata per l'aggiunta di un ulteriore
	 * parametro, che tiene traccia del vertice di provenienza.
	 * <p>
	 * Durante la scansione dfs si controllano i vertici adiacenti al vertice in
	 * esame. Se il vertice non è stato ancora visitato, l'attraversamento procede
	 * nel modo usuale. Altrimenti (e qui è il punto di diversità) poiché il vertice
	 * è già stato visitato, occorre solo controllare che questo vertice sia diverso
	 * da quello di provenienza. Se il grafo è privo di cicli, durante
	 * l'attraversamento ogni vertice è adiacente ad uno e un solo vertice già
	 * visitato (cioè quello di provenienza). Se si incontra un vertice adiacente,
	 * già visitato, diverso da quello di provenienza, il grafo ha un ciclo.
	 *
	 * @param v
	 * @param u
	 */
	private void dfs(int v, int u) {
//		System.out.format("dfs(%d, %d)%n", v, u);
		visited[v] = true;
		for (int w : g.adjacencies(v)) {
			if (!visited[w]) {
				dfs(w, v);
			}
			else
				if (w != u) {
//					System.out.println("\tciclo trovato");
					hasCycle = true;
				}
		}
	}




	public boolean hasCycle() {
		return hasCycle;
	}


}
