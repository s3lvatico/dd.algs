package org.gmnz.ddi.algs.sort;


public class SelectionSort<KEY extends Comparable<KEY>> extends AbstractSortEngine<KEY> {

	protected SelectionSort(KEY[] arr) {
		super(arr);
	}




	@Override
	protected void sort() {
		if (arrayLength < 2) {
			return;
		}
		for (int i = 0; i < arrayLength; i++) {
			int min = i;
			for (int j = i + 1; j < arrayLength; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			swap(i, min);
		}
	}

}
