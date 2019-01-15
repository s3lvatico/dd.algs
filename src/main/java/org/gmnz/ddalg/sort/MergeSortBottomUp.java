package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.In;


/**
 * Un altro modo di applicare la strategia del mergesort è di partire prima da
 * subarray piccoli (al limite, di dimensione 1), ordinati, fonderli e poi
 * passare a subarray di lunghezza 2. E così, via: da 2 a 4, da 4 a 8...
 * 
 * @author gemini
 *
 */
public class MergeSortBottomUp extends AbstractMergeSort {

	@Override
	public Comparable[] sort(Comparable[] a) {
		aux = new Comparable[a.length];

		int len = a.length;
		for (int sz=1; sz < len; sz+=sz) {
			for(int lo = 0; lo < len -sz; lo += sz+sz) {
				a = merge(a, lo, lo + sz-1, Math.min( lo+sz+sz-1, len-1));
			}
		}
		return a;
	}



	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In(args[0]).readAllStrings();
		AbstractSortEngine sortEngine = new MergeSortBottomUp();
		a = (String[]) sortEngine.sort(a);
		assert sortEngine.isSorted(a);
		sortEngine.show(a);
	}

}
