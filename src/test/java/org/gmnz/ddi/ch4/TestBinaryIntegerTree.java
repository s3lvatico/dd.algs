package org.gmnz.ddi.ch4;

public class TestBinaryIntegerTree {

	public static void main(String[] args) {
		BasicBinaryTree<Integer> tree = new BasicBinaryTree<Integer>();
		System.out.println(tree.nodeCount);
		System.out.println(tree.nodes());

		tree.build(new Integer[] {1, 2, 3});
		System.out.println(tree.nodeCount);
		System.out.println(tree.nodes());

		tree.build(new Integer[] {2, 3, 5, 7, 11, 13, 17, 19});
		System.out.println(tree.nodeCount);
		System.out.println(tree.nodes());
	}
}
