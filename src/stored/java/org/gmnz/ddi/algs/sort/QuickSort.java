package org.gmnz.ddi.algs.sort;


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
			// finché l'indice sx si mantiene all'interno dell'array e finché l'elemento
			// indicato da i è minore del pivot continuo la scansione verso dx
			while (i < hi && less(a[i], p)) {
				i++;
				// altrimenti mi fermo perché l'elemento non è in posizione giusta rispetto al
				// pivot nel semi-sub-array di sx, quindi andrà spostato
			}
			// finché l'indice destro si mantiene all'interno dell'array e finché l'elemento
			// indicato da j è NON MINORE del pivot continuo la scansione verso sx
			while (j > lo && !less(a[j], p)) {
				// ATTENZIONE: perché ho detto esplicitamente "maggiore o uguale"? Perché non ho
				// detto "minore"? La scelta è fondamentale per la riuscita dell'algoritmo, in
				// quanto fornisce una condizione per la quale uno degli indici può continuare a
				// muoversi, definitivamente incrociando l'altro indice. Con questa soluzione si
				// fa in modo che l'indice alto di scansione possa in ultimo incrociare quello
				// basso.
				j--;
				// altrimenti mi fermo perché l'elemento non è in posizione corretta rispetto al
				// pivot nel semi-sub-array di dx, quindi andrà spostato
			}
			// a fine scansione ho trovato due valori definitivi per i e j che, se sono
			// distinti e non "incrociati", indicano due elementi distinti che sono in
			// possizione errata rispetto al pivot, e che quindi vanno scambiati
			if (i < j) {
				swap(i, j);
			}
		}
		// resta solo da posizionare correttamente il pivot, che sarà nella posizione
		// indicata dall'indice j. L'indice j infatti indica, a fine iterazioni, il più
		// grande tra gli elementi minori o uguali al pivot
		swap(lo, j);
		return j;
	}

}
