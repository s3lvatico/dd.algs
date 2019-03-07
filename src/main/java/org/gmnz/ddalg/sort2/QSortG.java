package org.gmnz.ddalg.sort2;


public class QSortG {

	int[] sort(int[] v) {
		quicksort(v, 0, v.length - 1);
		return v;
	}



	private void quicksort(int[] v, int lo, int hi) {
		// ricorda sempre che è nei metodi ricorsivi che devi mettere la condizione di
		// terminazione!
		if (lo >= hi) {
			return;
		}
		int partIdx = partition(v, lo, hi);
		quicksort(v, lo, partIdx - 1);
		quicksort(v, partIdx, hi);
	}



	private void swap(int[] v, int x, int y) {
		int tmp = v[x];
		v[x] = v[y];
		v[y] = tmp;
	}



	int partition(int[] v, int lo, int hi) {
		int pivotIndex = (lo + hi) / 2;
		int pivot = v[pivotIndex];
		while (lo <= hi) {
			while (pivot > v[lo]) {
				++lo;
			}
			while (pivot < v[hi]) {
				hi--;
			}
			if (lo <= hi) {
				swap(v, lo, hi);
				lo++;
				hi--;
			}
		}
		return lo;
	}



	private static void print(int[] v) {
		for (int x : v) {
			System.out.print(x + " ");
		}
	}
	/* 9 5 7 6 8 3 4 1 2 */



	public static void main(String[] args) {
		int[] v = new int[] { 9, 5, 7, 6, 8, 3, 4, 1, 2 };
		QSortG qs = new QSortG();
		qs.sort(v);
		print(v);
	}
}
