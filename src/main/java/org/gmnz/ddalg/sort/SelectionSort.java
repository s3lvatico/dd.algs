package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.In;


public class SelectionSort extends AbstractSortEngine {

	@Override
	public Comparable[] sort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int idxMin = i;
			for (int j = i + 1; j < n; j++) {
				if (less(a[j], a[idxMin])) {
					idxMin = j;
				}
			}
			swap(a, i, idxMin);
		}
		return a;
	}



	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In(args[0]).readAllStrings();
		AbstractSortEngine sortEngine = new SelectionSort();
		a = (String[]) sortEngine.sort(a);
		assert sortEngine.isSorted(a);
		sortEngine.show(a);
	}

}
