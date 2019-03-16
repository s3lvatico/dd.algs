package org.gmnz.ddalg.graph2;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


class Bfs {

	private final Graph g;


	private Queue<Integer> q;
	private boolean[] visited;
	private int[] edgeTo;
	private int[] distanceTo;



	Bfs(Graph g) {
		this.g = g;
	}



	void search(int v) {
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
		search(v);
		return visited[v] && visited[w];
	}



	Collection<Integer> getPath(int v, int w) {
//		search(v);
		if (!pathExists(v, w)) {
			return null;
		}
		Deque<Integer> stack = new ArrayDeque<>();
		int x;
		for (x = v; distanceTo[x] != 0; x=edgeTo[x]) {
			stack.addFirst(x);
		}
		stack.addFirst(x);
		return stack;
	}

}
