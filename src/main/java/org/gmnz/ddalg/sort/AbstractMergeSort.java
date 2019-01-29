package org.gmnz.ddalg.sort;


abstract class AbstractMergeSort<KEY extends Comparable<KEY>> extends AbstractSortEngine {

	private KEY[] aux;



	protected AbstractMergeSort(Comparable[] arr) {
		super(arr);
		aux = (KEY[]) new Comparable[arrayLength];
	}



	/**
	 * Unisce i due subarray contenuti nell'array principale nell'intervallo
	 * [lo..mid] e [mid+1..hi]
	 * 
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	protected void merge(int lo, int mid, int hi) {
		// mi segno i punti in cui partono i due subarray
		int i = lo;
		int j = mid + 1;

		// preparo l'array ausiliario come copia dell'originale nell'intervallo chiuso
		// [lo..hi]
		for (int k = lo; k <= hi; k++) {
			aux[k] = (KEY) a[k];
		}

		// fusione

		// scansione di tutto l'intervallo di interesse
		for (int k = lo; k <= hi; k++) {
			// ho finito a sinistra?
			if (i > mid) {
				// allora prendo da destra
				a[k] = aux[j++];
			}
			else // ho finito a destra?
				if (j > hi) {
					// alllora prendo da sinistra
					a[k] = aux[i++];
				}
				else // confronto i due valori nei due subarray
						 // prendo il valore più piccolo puntato dagli indici
					if (less(aux[i], aux[j])) {
						a[k] = aux[i++];
					}
					else {
						a[k] = aux[j++];
					}
		}
	}

}
