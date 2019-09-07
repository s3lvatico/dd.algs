package org.gmnz.ddi.algs.sort;


abstract class AbstractMergeSort<KEY extends Comparable<KEY>> extends AbstractSortEngine<KEY> {

	private KEY[] aux;




	protected AbstractMergeSort(KEY[] arr) {
		super(arr);
		aux = (KEY[]) new Comparable[arrayLength];
	}




	/**
	 * Unisce i due subarray contenuti nell'array principale nell'intervallo
	 * [lo..mid] e [mid+1..hi].
	 * <p>
	 * Precondizione: lo <= mid <= hi
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

		// copio la porzione [lo..hi] di interesse nell'array ausiliario
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// fusione (con riordino)

		// scansione di tutto l'intervallo di interesse
		/*
		 * per ogni valore dell'indice k si considerano in sequenza i valori dei due
		 * array dei quali si vuol fare la fusione . Il k-esimo posto è occupato dal
		 * minore dei due valori indicati dagli indici di scansione i e j, fatti salvi i
		 * casi in cui i due subarray siano "esauriti". Quando si prende uno dei valori
		 * dei due array, il rispettivo indice di scansione viene fatto avanzare.
		 */
		for (int k = lo; k <= hi; k++) {
			// ho finito a sinistra?
			if (i > mid) {
				// allora prendo da destra
				a[k] = aux[j++]; // e l'indice del subarray destro scorre
			}
			else // ho finito a destra?
				if (j > hi) {
					// alllora prendo da sinistra
					a[k] = aux[i++]; // e l'indice del subarray sinistro scorre
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
