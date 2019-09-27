package org.gmnz.ddi.ctci.ch4.graph_old;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * per ipotesi diciamo che sia un grafo connesso
 *
 * @deprecated         idee troppo complicate per un ADT che dovrebbe essere
 *                     sufficientemente semplice da permetterne uno studio
 *                     efficace
 * @author
 *
 * @param      <KEY>
 * @param      <VALUE>
 */
@Deprecated
public class BasicConnectedGraph<KEY extends Comparable<KEY>, VALUE> implements Graph<KEY, VALUE> {

	class VisitableGraphNode extends GraphNode<KEY, VALUE> {

		boolean visited;


		VisitableGraphNode(KEY key, VALUE value) {
			super(key, value);
			visited = false;
		}

	}

	List<GraphNode<KEY, VALUE>> nodes;

	private Map<KEY, Boolean> visited;


	public BasicConnectedGraph() {
		nodes = new ArrayList<>();
	}



	@Override
	public void add(KEY key, VALUE value) {
		GraphNode<KEY, VALUE> node = new GraphNode<>(key, value);
		if (nodes.contains(node)) {
			System.err.println("node already present");
		}
		else {
			nodes.add(node);
		}
	}



	@Override
	public void connect(KEY k1, KEY k2) {
		/*
		 * trova k1 (se non esiste aggiungilo al grafo) trova k2 (se non esiste
		 * aggiungilo al grafo)
		 *
		 * aggiungi k2 alla lista di adiacenze di k1 aggiungi k1 alla lista di adiacenze
		 * di k2
		 *
		 */

	}



	@Override
	public boolean contains(KEY k) {
		visited = new HashMap<>();
		for (GraphNode<KEY, VALUE> node : nodes) {
			visited.put(node.key, Boolean.FALSE);
		}
		return false;
	}



	protected GraphNode<KEY, VALUE> dfs(GraphNode<KEY, VALUE> node, KEY k) {
		if (visited.get(node.key)) {
			return null;
		}
		if (node.key.equals(k)) {
			return node;
		}
		// for (GraphNode<KEY, VALUE> adjacentNode : node.adjacentNodes) {
		// // incompleto?
		// }
		return null;
	}
}
