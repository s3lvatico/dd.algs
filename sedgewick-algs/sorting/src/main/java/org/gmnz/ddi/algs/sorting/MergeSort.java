package org.gmnz.ddi.algs.sorting;

/**
 * MergeSort per array di interi
 */
public class MergeSort<K extends Comparable<K>> extends BaseSortEngine {

	// private int[] v;
	// private int[] aux;

	private K[] v;
	private K[] aux;

	public MergeSort(K[] v) {
		aux = (K[]) new Comparable[v.length];
		this.v = v;
	}



	/**
	 * ordina l'array specificato nel costruttore e lo restituisce
	 * 
	 * @return array ordinato
	 */
	public K[] sort() {
		mergeSort(0, v.length - 1);
		return v;
	}



	/**
	 * MergeSort.
	 * <p>
	 * Se gli indici {@code lo} e {@code hi} coincidono o si incrociano, si ferma la
	 * ricorsione.
	 * <p>
	 * Altrimenti viene individuato un indice intermedio e si fa ricorsione con i
	 * due subarray tra <code>[lo..mid]</code> e <code>[mid+1..hi]</code>. Quando
	 * gli array non sono ulteriormente suddivisibili, richiama
	 * {@link #merge(int, int, int)} sui due subarray, che ricreerà un subarray
	 * ordinato.
	 *
	 * @param lo
	 * @param hi
	 */
	private void mergeSort(int lo, int hi) {
		// controllo di terminazione della ricorsione
		if (lo >= hi) {
			return;
		}

		// indice intermedio
		int mid = (lo + hi) / 2;

		// ricorsione per il sub-array basso
		mergeSort(lo, mid);

		// ricorsione per il sub-array alto
		mergeSort(mid + 1, hi);

		// fusione delle parti
		merge(lo, mid, hi);
	}



	/**
	 * Unisce i due subarray contenuti nell'array principale nell'intervallo
	 * <code>[lo..mid]</code> e <code>[mid+1..hi]</code>.
	 * <p>
	 * Precondizione: <code>lo <= mid <= hi</code>
	 * 
	 */
	private void merge(int lo, int mid, int hi) {
		int r = lo;
		int s = mid + 1;

		// copio la porzione [lo..hi] di interesse nell'array ausiliario
		for (int k = lo; k <= hi; k++) {
			aux[k] = v[k];
		}

		// nell'intervallo lo..hi
		for (int i = lo; i <= hi; i++) {
			// nell'i-esima posizione di v:
			if (r > mid) {
				// se r è oltre mid vuol dire che ho esaurito tutti gli elementi dell'array a
				// sinistra, quindi prendo dall'array di destra
				v[i] = aux[s++];
			} else
				if (s > hi) {
					// se s è oltre hi vuol dire che ho esaurito tutti gli elementi dell'array
					// a destra, quindi prendo dall'array di sinistra
					v[i] = aux[r++];
				} else
					// ci sono ancora elementi di ambo gli array da considerare, quindi
					if (less(aux[r], aux[s])) {
						// a sinistra c'è un valore minore --> si prende da sinistra
						v[i] = aux[r++];
					} else {
						// a destra c'è un valore minore --> si prende da destra
						v[i] = aux[s++];
					}
		}
	}
}
