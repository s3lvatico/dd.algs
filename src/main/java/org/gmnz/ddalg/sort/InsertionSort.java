package org.gmnz.ddalg.sort;

public class InsertionSort<KEY extends Comparable<KEY>> extends AbstractSortEngine<KEY> {

	protected InsertionSort(KEY[] arr) {
		super(arr);
	}



	@Override
	protected void sort() {
		if (arrayLength < 2) {
			return;
		}
		for (int i = 1; i < arrayLength; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j - 1])) {
					swap(j, j-1);
				}
			}
		}
	}

}
