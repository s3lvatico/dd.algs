package org.gmnz.ddi.algs.sort2;


public class QSortG<K extends Comparable<K>> extends AbstractSortEngine<K> {

	@SuppressWarnings("unchecked")
	public QSortG(K[] arr) {
		if (arr == null)
			this.v = (K[]) new Comparable[0];
		else
			v = arr;
	}



	public void sort() {
		quicksort(0, v.length - 1);
	}

	/*
	 * ricorda sempre che è nei metodi ricorsivi che devi mettere la condizione di
	 * terminazione
	 */



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
	 * il cuore del qs.
	 * <p>
	 *
	 *
	 * @param  v
	 * @param  lo
	 * @param  hi
	 * @return
	 */
	int partition(int lo, int hi) {
		// determina l'indice dell'elemento rispetto al quale partizionare (lo si chiama
		// pivot)
		int pivotIndex = (lo + hi) / 2;
		// seleziona (isola) il pivot
		K pivot = v[pivotIndex];
		// In questo ciclo while gli indici lo e hi scorrono l'uno verso l'altro. ("lo"
		// si incrementa e "hi" si decrementa).
		// Il ciclo continua finché "lo" è non maggiore di "hi" (i due indici non si
		// incrociano, al massimo coincidono)
		while (lo <= hi) {
			// sessione di scorrimento degli indici, alla fine della quale occorre
			// controllare ancora che gli indici rispettino la condizione all'inizio del
			// ciclo - questo è necessario per capire se si deve fare uno scambio oppure no

			// --

			// se gli elementi a sinistra [destra] del pivot sono strettamente minori
			// [maggiori] del pivot allora sono già in posizione giusta, perciò si fa
			// scorrere l'indice "lo" [ "hi" ]
			while (less(v[lo], pivot)) {
				++lo;
			}
			while (less(pivot, v[hi])) {
				--hi;
			}
			// se i cursori non si sono incrociati si può fare lo scambio posizionale
			if (lo <= hi) {
				swap(lo, hi);
				// i cursori vengono comunque fatti scorrere, poiché gli elementi che sono stati
				// scambiati di posto ora occupano sicuramente la posizione corretta rispetto al
				// pivot
				lo++;
				hi--;
			}
		}
		return lo;
	}

}
