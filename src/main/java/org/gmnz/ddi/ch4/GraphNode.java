package org.gmnz.ddi.ch4;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class GraphNode {

	private Integer value;
	private Set<GraphNode> adjacentNodes;



	public GraphNode(Integer value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.value = value;
		this.adjacentNodes = new HashSet<GraphNode>();
	}



	public void newEdgeTo(GraphNode node) {
		adjacentNodes.add(node);
	}



	public Integer getValue() {
		return value;
	}



	public Collection<GraphNode> adjacentsNodes() {
		return Collections.unmodifiableSet(adjacentNodes);
	}
}
