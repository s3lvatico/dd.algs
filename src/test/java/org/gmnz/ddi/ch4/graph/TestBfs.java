package org.gmnz.ddi.ch4.graph;


public class TestBfs {

	public static void main(String[] args) {

/*
 * 12
 *
 * 0 1 2 6 5
 * 3 4 5
 * 4 5 6
 * 7 8
 * 9 10 11 12
 * 11 12
 *
 */

		Graph g = new Graph(13);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(0, 6);

		g.addEdge(3, 4);
		g.addEdge(3, 5);

		g.addEdge(4, 5);
		g.addEdge(4, 6);

		g.addEdge(7, 8);

		g.addEdge(9, 10);
		g.addEdge(9, 11);
		g.addEdge(9, 12);

		g.addEdge(11, 12);



		Bfs bfs = new Bfs(g);
		bfs.bfs(0);

		bfs.bfs(11);
		bfs.bfs(12);
		bfs.bfs(4);

	}

}
