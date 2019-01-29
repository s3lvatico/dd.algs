package org.gmnz.ddalg.sort;


public class SelectionSort<KEY extends Comparable> extends AbstractSortEngine {

	protected SelectionSort(KEY[] arr) {
		super(arr);
	}



	@Override
	protected void sort() {
		int N = a.length;
		if (N == 0) {
			return;
		}
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[i])) {
					min = j;
				}
			}
			swap(i, min);
		}
	}



}
