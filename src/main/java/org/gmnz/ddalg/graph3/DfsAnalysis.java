package org.gmnz.ddalg.graph3;


import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;


class DfsAnalysis implements GraphAnalysis {


	private boolean[] visited;
	private int[] edgeTo;

	private final Graph g;

	private int sourceVertex;




	DfsAnalysis(Graph g, int sourceVertex) {
		this.g = g;
		this.sourceVertex = sourceVertex;
		visited = new boolean[g.countVertices()];
		edgeTo = new int[g.countVertices()];
		dfs(sourceVertex);
	}




	private void dfs(int v) {
		visited[v] = true;
		for (int w : g.adjacencies(v)) {
			if (!visited[w]) {
				edgeTo[w] = v;
				dfs(w);
			}
		}

	}




	@Override
	public boolean hasPathTo(int v) {
		return visited[v];
	}




	@Override
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
