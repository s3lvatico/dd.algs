package org.gmnz.ddalg.sort2;


public class MSortG {
	private int[] aux;



	int[] sort(int[] v) {
		aux = new int[v.length];
		mergeSort(v, 0, v.length - 1);
		return v;
	}



	private void mergeSort(int[] v, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int mid = (lo + hi) / 2;
/*
 * avrei voluto fare in modo simile al quicksort, in cui partizionavo in
 * [lo..mid-1] e [mid..hi], ma nel caso del mergesort non è possibile perché il
 * punto di partizionamento nel mergesort NON E' determinato in modo "preciso",
 * ossia dipende dalla posizione intera del punto medio tra lo e hi.
 * Se l'operazione di media, è vero, arrotonda verso il basso, mi assicuro la
 * certezza che usando [lo..mid] e [mid+1..hi] prima o poi gli indici si
 * incroceranno e la ricorsione terminerà.
 */
		mergeSort(v, lo, mid);
		mergeSort(v, mid + 1, hi);
		merge(v, lo, mid, hi);
	}



	private void initAux(int[] v, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = v[i];
		}
	}



	private void merge(int[] v, int lo, int mid, int hi) {
		initAux(v, lo, hi);
		int r = lo;
		int s = mid+1;
		for (int i = lo; i <= hi; i++) {
			if (r > mid) {
				v[i] = aux[s++];
			}
			else
				if (s > hi) {
					v[i] = aux[r++];
				}
				else
					if (aux[r] < aux[s]) {
						v[i] = aux[r++];
					}
					else {
						v[i] = aux[s++];
					}
		}
	}



	private static void print(int[] v) {
		for (int x : v) {
			System.out.print(x + " ");
		}
	}
	/* 9 5 7 6 8 3 4 1 2 */



	public static void main(String[] args) {
		int[] v = new int[] { 9, 5, 7, 6, 8, 3, 4, 1, 2 };
		MSortG qs = new MSortG();
		qs.sort(v);
		print(v);
	}
}
