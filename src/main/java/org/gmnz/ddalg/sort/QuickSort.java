package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;


public class QuickSort extends AbstractSortEngine {

	QuickSort(Comparable[] arr) {
		super(arr);
		StdRandom.shuffle(a);
	}



	@Override
	protected void sort() {
		sort(0, arrayLength - 1);
	}



	void sort(int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int j = partition(lo, hi);
		sort(lo, j);
		sort(j + 1, hi);
	}



	private int partition(int lo, int hi) {
		int i = lo;
		int j = hi;
		Comparable p = a[lo];

		while (i < j) {
			while (i < hi) {
				if (less(p, a[i])) {
					break;
				} else {
					i++;
				}
			}
			while (j > lo) {
				if (less(a[j], p)) {
					break;
				} else {
					j--;
				}
			}
			if (i >= j) {
				break;
			}
			swap(i, j);
		}
		swap(lo, j);
		return j;
	}



	Comparable[] getResult() {
		return a;
	}



	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In(args[0]).readAllStrings();

		QuickSort sort = new QuickSort(a);
		sort.sort();
		sort.show();
	}

}
