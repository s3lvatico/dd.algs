package org.gmnz.ddalg.sort.thrown;

abstract class AbstractMergeSort extends AbstractSortEngine {

	protected Comparable[] aux;



	protected Comparable[] merge(Comparable[] a, int lo, int mid, int hi) {
		// mi segno i punti in cui partono i due subarray
		int i = lo;
		int j = mid + 1;

		// preparo l'array ausiliario come copia dell'originale nell'intervallo chiuso
		// [lo..hi]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// fusione
		for (int k = lo; k <= hi; k++) {
			// ho finito a sinistra?
			if (i > mid) {
				// allora prendo da destra
				a[k] = aux[j++];
			} else // ho finito a destra?
				if (j > hi) {
					// alllora prendo da sinistra
					a[k] = aux[i++];
				} else // confronto i due valori nei due subarray
					if (less(aux[i], aux[j])) {
						a[k] = aux[i++];
					} else {
						a[k] = aux[j++];
					}
		} // ciclo for
		return a;
	}

}
