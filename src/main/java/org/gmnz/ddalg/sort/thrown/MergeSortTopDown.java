package org.gmnz.ddalg.sort.thrown;


import edu.princeton.cs.algs4.In;


public class MergeSortTopDown extends AbstractMergeSort {

	@Override
	public Comparable[] sort(Comparable[] a) {
		aux = new Comparable[a.length];
		return sort(a, 0, a.length - 1);
	}



	private Comparable[] sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return a;
		}

		int mid = lo + (hi - lo) / 2;
		a = sort(a, lo, mid);
		a = sort(a, mid + 1, hi);
		a = merge(a, lo, mid, hi);
		return a;
	}



	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In(args[0]).readAllStrings();
		AbstractSortEngine sortEngine = new MergeSortTopDown();
		a = (String[]) sortEngine.sort(a);
		assert sortEngine.isSorted(a);
		sortEngine.show(a);
	}

}
