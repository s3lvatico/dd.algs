package org.gmnz.ddi.ch4.graph_old;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


class GraphNode<KEY extends Comparable<KEY>, VALUE> extends Node<KEY, VALUE> {

	protected Set<GraphNode<KEY, VALUE>> adjacentNodes;




	GraphNode(KEY key, VALUE value) {
		super(key, value);
		adjacentNodes = new HashSet<>();
	}




	void addEdgeTo(GraphNode<KEY, VALUE> node) {
		adjacentNodes.add(node);
	}




	Collection<GraphNode<KEY, VALUE>> adjacentNodes() {
		return Collections.unmodifiableSet(adjacentNodes);
	}

}
