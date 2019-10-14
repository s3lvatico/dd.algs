package org.gmnz.ddi.algs.sorting;


/**
 * MergeSort per array di interi
 */
public class MergeSort extends BaseSortEngine {

	private int[] aux;
	private int[] v;

	public MergeSort(int[] v) {
		aux = new int[v.length];
		this.v = v;
	}



	public int[] sort() {
		mergeSort(0, v.length - 1);
		return v;
	}



	/**
	 * MergeSort.
	 * <p>
	 * Se gli indici {@code lo} e {@code hi} coincidono o si incrociano, si ferma la
	 * ricorsione.
	 * <p>
	 * Altrimenti viene individuato un indice intermedio e viene richiamato questo
	 * stesso metodo con i due subarray tra <code>[lo..mid]</code> e
	 * <code>[mid+1..hi]</code>. Quando gli array non sono ulteriormente
	 * suddivisibili, riachiama {@link #merge(int, int, int)} delle due parti
	 * individuate, che ricreerà un subarray ordinato.
	 *
	 * @param lo
	 * @param hi
	 */
	private void mergeSort(int lo, int hi) {
		// terminazione della ricorsione
		if (hi <= lo) {
			return;
		}

		// indice intermedio
		int mid = lo + (hi - lo) / 2;

		// ricorsione per il sub-array basso
		mergeSort(lo, mid);

		// ricorsione per il sub-array alto
		mergeSort(mid + 1, hi);

		// fusione delle parti
		merge(lo, mid, hi);
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
	private void merge(int lo, int mid, int hi) {
		// mi segno i punti in cui partono i due subarray
		int i = lo;
		int j = mid + 1;

		// copio la porzione [lo..hi] di interesse nell'array ausiliario
		for (int k = lo; k <= hi; k++) {
			aux[k] = v[k];
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
				v[k] = aux[j++]; // e l'indice del subarray destro scorre
			}
			else // ho finito a destra?
				if (j > hi) {
					// alllora prendo da sinistra
					v[k] = aux[i++]; // e l'indice del subarray sinistro scorre
				}
				else // confronto i due valori nei due subarray
						// prendo il valore più piccolo puntato dagli indici
					if (less(aux[i], aux[j])) {
						v[k] = aux[i++];
					}
					else {
						v[k] = aux[j++];
					}
		}
	}
}