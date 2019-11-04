package org.gmnz.ddi.algs.sorting;


public class QuickSort extends BaseSortEngine {

	private int[] v;

	public QuickSort(int[] arr) {
		if (arr == null)
			this.v = new int[0];
		else
			v = arr;
	}



	public int[] sort() {
		quicksort(0, v.length - 1);
		return v;
	}



	private void quicksort(int lo, int hi) {
		// se gli indici coincidono o sono incrociati sto cercando di ordinare un array
		// degenere
		if (lo >= hi) {
			return;
		}
		int partIdx = partition(lo, hi);
		quicksort(lo, partIdx - 1);
		quicksort(partIdx, hi);
	}



	/**
	 * Il cuore del qs è il <b>partizionamento</b>. In questo contesto,
	 * "partizionare" significa manipolare l'array iniziale in qualche modo e
	 * restituire al client un indice tale che (1) tutti gli elementi a sinistra di
	 * quell'indice sono strettamente minori del valore presente a quell'indice, (2)
	 * tutti gli elementi a destra sono maggiori del valore presente a quell'indice.
	 * <p>
	 * Per trovare l'indice si sceglie un elemento arbitrario dell'array.
	 * Tipicamente si sceglie di usare l'elemento che si trova verso il centro
	 * dell'array. Dati poi {@code lo} e {@code hi} gli indici entro i quali
	 * lavorare, si confrontano i valori presenti a quegli indici con il pivot
	 * scelto.
	 * 
	 *
	 * 
	 * @param  lo indice basso
	 * @param  hi indice alto
	 * @return    indice di partizionamento
	 */
	int partition(int lo, int hi) {

		// seleziona (isola) il pivot
		int pivot = v[(lo + hi) / 2];

		// In questo ciclo while gli indici lo e hi scorrono l'uno verso l'altro. ("lo"
		// si incrementa e "hi" si decrementa).
		// Il ciclo continua finché gli indici non si incontrano o non si incrociano.
		while (lo <= hi) {
			// sessione di scorrimento degli indici, alla fine della quale occorre
			// controllare ancora che gli indici rispettino la condizione all'inizio del
			// ciclo - questo è necessario per capire se si deve fare uno scambio oppure no

			// se gli elementi puntati da "lo" [ "hi" ] sono strettamente minori
			// [maggiori] del pivot allora significa che si trovano già nella partizione
			// giusta, perciò si fa scorrere l'indice "lo" [ "hi" ]
			while (less(v[lo], pivot)) {
				++lo;
			}
			while (less(pivot, v[hi])) {
				--hi;
			}

			// se i cursori non si sono (ancora) incrociati si può fare lo scambio
			// posizionale
			if (lo <= hi) {
				if (v[lo] != v[hi])
					// ma solo se effettivamente ce n'è bisogno, è inutile scambiare due valori
					// uguali
					swap(v, lo, hi);

				// i cursori vengono comunque fatti scorrere
				lo++;
				hi--;
			}
		}
		// "lo" in effetti risulta essere più importante di "hi", perché in ultimo
		// contiene il vero indice di partizionamento dell'array. La porzione di array
		// considerata è ora in uno stato per cui tutti gli elementi (strettamente) a
		// sinistra di "lo" sono (strettamente) minori del pivot originale, mentre
		// quelli da "lo" in poi sono non-minori del pivot
		return lo;
	}

}
