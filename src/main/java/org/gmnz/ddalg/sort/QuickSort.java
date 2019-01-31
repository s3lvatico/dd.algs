package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;


public class QuickSort<KEY extends Comparable<KEY>> extends AbstractSortEngine<KEY> {

	QuickSort(KEY[] arr) {
		super(arr);
		StdRandom.shuffle(a);
	}



	@Override
	protected void sort() {
		sort(0, arrayLength - 1);
	}



	/**
	 * Richiama questo metodo ricorsivamente finché gli indici non collassano.
	 * Altrimenti l'ordinamento viene eseguito individuando nell'intervallo
	 * <code>[lo..hi]</code> un elemento pivot, e riarrangiando l'array in modo tale
	 * che l'elemento pivot sia in posizione corretta (rispetto all'array finale
	 * ordinato) e che tutti gli elemento minori di esso siano posizionati prima, e
	 * che tutti gli elementi maggior di esso siano posizionati dopo.
	 * <p>
	 * Questa operazione è svolta dal metodo {@link #partition(int, int)} .
	 *
	 * @param lo
	 * @param hi
	 */
	void sort(int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int j = partition(lo, hi);
		sort(lo, j);
		sort(j + 1, hi);
	}



	private int partition(int lo, int hi) {
		// gli indici di scansione
		int i = lo;
		int j = hi;

		// fissa il pivot scegliendolo deliberatamente pari al primo elemento
		// nell'intervallo specificato
		KEY p = a[lo];

		// finché gli indici di scansione non coincidono
		while (i < j) {
			// finché l'indice sx si mantiene all'interno dell'array
			while (i < hi && less(a[i], p)) {
				// se l'elemento indicato da i è minore del pivot continuo la scansione
				// if (less(a[i], p)) {
				i++;
				// }
				// altrimenti mi fermo perché l'elemento non è in posizione giusta rispetto al
				// pivot, e dovrà quindi essere spostato
//				else {
//					break;
//				}
			}
			// finché l'indice destro si mantiene all'interno dell'array
			while (j > lo && !less(a[j], p)) {
				// se l'elemento indicato da j è maggiore o uguale al pivot continuo la
				// scansione
				// ATTENZIONE: perché ho detto esplicitamente "maggiore o uguale"? Perché non ho
				// detto "minore"? La scelta è fondamentale per la riuscita dell'algoritmo, in
				// quanto fornisce una condizione per la quale uno degli indici può continuare a
				// muoversi, definitivamente incrociando l'altro indice. Con questa soluzione si
				// fa in modo che l'indice alto di scansione possa in ultimo incrociare quello
				// basso.
//				if (!less(a[j], p)) {
				j--;
//				}
//				else {
//					// altrimenti mi fermo perché l'elemento non è in posizione corretta
//					break;
//				}
			}
			// a fine scansione ho trovato due valori definitivi per i e j che, se sono
			// distinti e non "incrociati", indicano due elementi distinti che sono in
			// possizione errata rispetto al pivot, e che quindi vanno scambiati
			if (i < j) {
				swap(i, j);
			}
		}
		//
		swap(lo, j);
		return j;
	}



	Comparable[] getResult() {
		return a;
	}



	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In("qsortexample.txt").readAllStrings();

		QuickSort sort = new QuickSort(a);
		sort.sort();
		sort.show();
	}

}
