package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class QSort2 {

	private Comparable[] a;



	QSort2(Comparable[] arr) {
		this.a = arr;
		StdRandom.shuffle(a);
	}



	void sort() {
		sort(0, a.length - 1);
	}



	void sort(int lo, int hi) {
		if (lo >= hi)
			return;
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
			if (i >= j)
				break;
			swap(i, j);
		}
		swap(lo, j);
		return j;
	}



	private boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}



	private void swap(int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}



	Comparable[] getResult() {
		return a;
	}



	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}



	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In(args[0]).readAllStrings();

		QSort2 sort = new QSort2(a);
		sort.sort();
		String[] result = (String[]) sort.getResult();
		show(result);
	}

}
