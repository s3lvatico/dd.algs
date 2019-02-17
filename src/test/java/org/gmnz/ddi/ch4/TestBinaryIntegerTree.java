package org.gmnz.ddi.ch4;

import java.util.Arrays;
import java.util.Random;

import org.gmnz.ddi.ch4.BinaryTree.Traversal;

public class TestBinaryIntegerTree {

	public static void main(String[] args) {
		BasicBinaryTree<Integer> tree = new BasicBinaryTree<Integer>();
		final int LENGTH = 15;
		Integer[] v = new Integer[LENGTH];
		Random rnd = new Random();
		for (int i=0; i< LENGTH; i++) {
			v[i] = rnd.nextInt(100);
		}

		Arrays.sort(v);
		tree.build(v);
		tree.display(Traversal.IN_ORDER);
	}
}
