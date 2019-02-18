package org.gmnz.ddi.ch4;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.gmnz.ddi.ch4.BinaryTree.Node;


public class NodeRepository<T> {

	private Map<Integer, Set<T>> repository;



	NodeRepository() {
		repository = new HashMap<Integer, Set<T>>();
	}



	public void addNode(int level, Node<T> node) {
		if (repository.get(level) == null) {
			repository.put(level, new HashSet<T>());
		}
		repository.get(level).add(node.value);
	}

	public void display() {
		for (Integer level : repository.keySet()) {
			System.out.format("level #%d : %s%n", level, repository.get(level));
		}
	}

}
