package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.StdOut;
abstract class AbstractSort {

	protected Comparable[] a;



	protected AbstractSort(Comparable[] arr) {
		if (arr == null) {
			this.a = new Comparable[] { new Comparable() {
				@Override
				public int compareTo(Object o) {
					return 0;
				}
			} };

		}
		else {
			this.a = arr;
		}
	}



	protected abstract void sort();



	protected void swap(int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}



	protected boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}



	protected boolean isSorted() {
		for (int i = 0; i < a.length - 1; i++) {
			if (less(a[i + 1], a[i])) {
				return false;
			}
		}
		return true;
	}



	protected void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
}
