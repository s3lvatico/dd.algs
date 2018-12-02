package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.StdIn;


public class InsertionSort {

	private static void sort(Comparable[] v) {
		for (int i = 1; i < v.length; i++) {
			for (int j = i; j > 0 && BasicSortEngine.less(v[j], v[j - 1]); j--) {
				BasicSortEngine.swap(v, j, j - 1);
			}
		}
	}



	public static void main(String[] args) {
		String[] v = StdIn.readAllStrings();
		BasicSortEngine.show(v);
		sort(v);
		BasicSortEngine.show(v);
	}
}
