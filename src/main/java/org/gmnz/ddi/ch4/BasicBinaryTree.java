package org.gmnz.ddi.ch4;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.StdOut;


public class BasicBinaryTree<T> implements BinaryTree<T> {


	protected Node<T> root;
	protected int nodeCount;




	@Override
	public void display(Traversal traversal) {
		display(root, traversal);
		StdOut.println();
	}




	protected void display(Node<T> node, Traversal traversal) {
		if (node == null) {
			return;
		}
		switch (traversal) {
		case PRE_ORDER:
			StdOut.print(node.value + " ");
			display(node.left, traversal);
			display(node.right, traversal);
			break;
		case IN_ORDER:
			display(node.left, traversal);
			StdOut.print(node.value + " ");
			display(node.right, traversal);
			break;
		case POST_ORDER:
			display(node.left, traversal);
			display(node.right, traversal);
			StdOut.print(node.value + " ");
		}
	}




	@Override
	public Collection<Node<T>> nodes() {
		Set<Node<T>> nodeSet = new HashSet<BinaryTree.Node<T>>(nodeCount);
		nodes(root, nodeSet);
		return nodeSet;
	}




	protected void nodes(Node<T> n, Set<Node<T>> nodeSet) {
		if (n == null) {
			return;
		}
		nodes(n.left, nodeSet);
		nodeSet.add(n);
		nodes(n.right, nodeSet);
	}




	@Override
	public Node<T> find(T t) {
		return findNode(root, t);
	}




	protected Node<T> findNode(Node<T> node, T value) {
		// preorder
		if (node == null) {
			return null;
		}
		if (node.value.equals(value)) {
			return node;
		}
		Node<T> hit = findNode(node.left, value);
		return hit != null ? hit : findNode(node.right, value);
	}




	@Override
	public void build(T[] keys) {
		nodeCount = 0;
		if (keys == null || keys.length == 0) {
			root = null;
			return;
		}

		root = partition(keys, 0, keys.length - 1);
	}




	protected Node<T> partition(T[] v, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		if (lo == hi) {
			Node<T> node = new Node<T>();
			node.value = v[lo];
			node.left = null;
			node.right = null;
			nodeCount++;
			return node;
		}
		int mid = lo + (hi - lo) / 2;
		Node<T> node = new Node<T>();
		node.value = v[mid];
		node.left = partition(v, lo, mid - 1);
		node.right = partition(v, mid + 1, hi);
		nodeCount++;
		return node;
	}




	@Override
	public boolean isEmpty() {
		return nodeCount == 0;
	}



}
