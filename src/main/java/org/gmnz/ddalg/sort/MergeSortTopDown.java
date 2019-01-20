package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.In;


public class MergeSortTopDown extends AbstractMergeSort {

	protected MergeSortTopDown(Comparable[] arr) {
		super(arr);
	}



	@Override
	public void sort() {
		sort(a, 0, a.length - 1);
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
		MergeSortTopDown sortEngine = new MergeSortTopDown(a);
		sortEngine.sort();
		sortEngine.show(a);
	}

}
