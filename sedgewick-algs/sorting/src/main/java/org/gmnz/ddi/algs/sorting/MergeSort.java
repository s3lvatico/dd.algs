package org.gmnz.ddi.algs.sorting;


/**
 * MergeSort per array di interi
 */
public class MergeSort extends BaseSortEngine {

	private int[] v;
	private int[] aux;

	public MergeSort(int[] v) {
		aux = new int[v.length];
		this.v = v;
	}



	/**
	 * ordina l'array specificato nel costruttore e lo restituisce
	 * 
	 * @return array ordinato
	 */
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
	 * suddivisibili, richiama {@link #merge(int, int, int)} delle due parti
	 * individuate, che ricreerà un subarray ordinato.
	 *
	 * @param lo
	 * @param hi
	 */
	private void mergeSort(int lo, int hi) {
		// terminazione della ricorsione
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
}
