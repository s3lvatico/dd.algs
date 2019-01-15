package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.In;


public class QSort extends AbstractSortEngine {

	@Override
	public Comparable[] sort(Comparable[] a) {
		return sort(a, 0, a.length - 1);
	}



	private Comparable[] sort(Comparable[] a, int lo, int hi) {
		int j = partition(a, lo, hi);
		a = sort(a, lo, j - 1);
		a = sort(a, j + 1, hi);
		return a;
	}



	/**
	 * è proprio questo metodo che di fatto esegue l'ordinamento. Deve trovare e
	 * restituire l'indice di un elemento che sia già in ordine nell'array finale.
	 * Inoltre, questo metodo riposiziona il contenuto dell'array (nei limiti
	 * indicati).
	 * <p>
	 * Identifica un indice j tale che: 1) l'elemento a[j] è già nella giusta
	 * posizione nell'array ordinato, 2) tutti gli elementi in [lo..j-1] sono minori
	 * di a[j], 3) tutti gli elementi in [j+1..hi] sono maggiori di a[j]
	 * 
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	private int partition(Comparable[] a, int lo, int hi) {
		// TODO da scoprire
		return -1;
	}



	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In(args[0]).readAllStrings();
		AbstractSortEngine sortEngine = new QSort();
		a = (String[]) sortEngine.sort(a);
		assert sortEngine.isSorted(a);
		sortEngine.show(a);
	}

}
