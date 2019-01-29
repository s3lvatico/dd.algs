package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.In;


public class MergeSortTopDown extends AbstractMergeSort {

	protected MergeSortTopDown(Comparable[] arr) {
		super(arr);
	}



	@Override
	public void sort() {
		sort(0, arrayLength - 1);
	}



	private void sort(int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		sort(lo, mid);
		sort(mid + 1, hi);
		merge(lo, mid, hi);
	}



	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In(args[0]).readAllStrings();
		MergeSortTopDown sortEngine = new MergeSortTopDown(a);
		sortEngine.sort();
		sortEngine.show();
	}

}
