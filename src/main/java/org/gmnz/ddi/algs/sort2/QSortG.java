package org.gmnz.ddi.algs.sort2;


import java.util.Random;


public class QSortG {

	int[] sort(int[] v) {
		quicksort(v, 0, v.length - 1);
		return v;
	}

	/*
	 * ricorda sempre che è nei metodi ricorsivi che devi mettere la condizione di
	 * terminazione
	 */



	private void quicksort(int[] v, int lo, int hi) {
		// se gli indici coincidono o sono incrociati sto cercando di ordinare un array
		// degenere
		if (lo >= hi) {
			return;
		}
		int partIdx = partition(v, lo, hi);
		quicksort(v, lo, partIdx - 1);
		quicksort(v, partIdx, hi);
	}



	private void swap(int[] v, int x, int y) {
		int tmp = v[x];
		v[x] = v[y];
		v[y] = tmp;
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
	int partition(int[] v, int lo, int hi) {
		// determina l'indice dell'elemento rispetto al quale partizionare (lo si chiama
		// pivot)
		int pivotIndex = (lo + hi) / 2;
		// seleziona (isola) il pivot
		int pivot = v[pivotIndex];
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
			while (v[lo] < pivot) {
				++lo;
			}
			while (pivot < v[hi]) {
				--hi;
			}
			// se i cursori non si sono incrociati si può fare lo scambio posizionale
			if (lo <= hi) {
				swap(v, lo, hi);
				// i cursori vengono comunque fatti scorrere, poiché gli elementi che sono stati
				// scambiati di posto ora occupano sicuramente la posizione corretta rispetto al
				// pivot
				lo++;
				hi--;
			}
		}
		return lo;
	}



	private static void print(int[] v) {
		for (int x : v) {
			System.out.print(x + " ");
		}
	}
	/* 9 5 7 6 8 3 4 1 2 */



	static boolean isSorted(int[] v) {
		if (v == null || v.length <= 1)
			return true;
		for (int i = 1; i < v.length; i++) {
			if (v[i - 1] > v[i])
				return false;
		}
		return true;
	}



	public static void main(String[] args) {
		int[] v = new int[] { 9, 5, 7, 6, 8, 3, 4, 1, 2 };
		QSortG qs = new QSortG();
		qs.sort(v);
		print(v);
		System.out.format("sorted? %s%n", isSorted(v));
		System.out.println();
		Random rnd = new Random();
		v = new int[100];
		for (int i = 0; i < 100; i++) {
			v[i] = rnd.nextInt(500);
		}
		qs.sort(v);
		print(v);
		System.out.format("sorted? %s%n", isSorted(v));
	}
}
