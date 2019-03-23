package org.gmnz.ddi.ch4.graph_old;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Deprecated
public class OldGraphNode {

	private Integer value;
	private Set<OldGraphNode> adjacentNodes;




	public OldGraphNode(Integer value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.value = value;
		this.adjacentNodes = new HashSet<OldGraphNode>();
	}




	public void newEdgeTo(OldGraphNode node) {
		adjacentNodes.add(node);
	}




	public Integer getValue() {
		return value;
	}




	public Collection<OldGraphNode> adjacentsNodes() {
		return Collections.unmodifiableSet(adjacentNodes);
	}
}
