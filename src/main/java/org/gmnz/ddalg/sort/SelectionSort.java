package org.gmnz.ddalg.sort;

import edu.princeton.cs.algs4.StdIn;

public class SelectionSort {

	private static void sort(Comparable[] v) {
		for (int i = 0; i < v.length; i++) {
			int min = i;
			for (int j = i; j < v.length; j++) {
				if (BasicSortEngine.less(v[j], v[min])) {
					min = j;
				}
			}
			BasicSortEngine.swap(v, i, min);
		}
	}
	
	
	
	public static void main(String[] args) {
		String[] v = StdIn.readAllStrings();
		sort(v);
		BasicSortEngine.show(v);
	}
}
