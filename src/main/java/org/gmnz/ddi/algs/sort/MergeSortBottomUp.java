package org.gmnz.ddi.algs.sort;


import edu.princeton.cs.algs4.In;


public class MergeSortBottomUp extends AbstractMergeSort {

	protected MergeSortBottomUp(Comparable[] arr) {
		super(arr);
	}




	@Override
	protected void sort() {
		int len = arrayLength;
		for (int ss = 1; ss < len; ss += ss) {
			for (int lo = 0; lo < len - ss; lo += ss + ss) {
				merge(lo, lo + ss - 1, Math.min(lo + ss + ss - 1, len - 1));
			}
		}
	}




	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In(args[0]).readAllStrings();
		AbstractSortEngine sortEngine = new MergeSortBottomUp(a);
		sortEngine.sort();
		assert sortEngine.isSorted();
		sortEngine.show();
	}
}
