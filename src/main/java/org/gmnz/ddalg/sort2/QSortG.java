package org.gmnz.ddalg.sort2;


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
	 * @param v
	 * @param lo
	 * @param hi
	 * @return
	 */
	int partition(int[] v, int lo, int hi) {
		// determina l'indice dell'elemento rispetto al quale partizionare (lo si chiama
		// pivot)
		int pivotIndex = (lo + hi) / 2;
		// seleziona (isola) il pivot
		int pivot = v[pivotIndex];
		// Internamente a questo ciclo while gli indici lo e hi scorrono. Il ciclo viene
		// eseguito finché hi resta strettamente maggiore di lo
		while (lo <= hi) {
			// sessione di scorrimento degli indici, alla fine della quale occorre
			// controllare ancora che gli indici rispettino la condizione all'inizio del
			// ciclo - questo è necessario per capire se si deve fare uno scambio oppure no
			while (pivot > v[lo]) {
				// incrementa prima il cursore basso
				// incrementa finché gli elementi a sinistra del pivot sono strettamente minori
				// del pivot
				++lo;
			}
			while (pivot < v[hi]) {
				// decrementa il cursore alto finché gli elementi a destra del pivot sono
				// maggiori del pivot
				--hi;
			}
			// se i cursori rispettano ancora la condizione di non decrescenza si può fare
			// lo scambio posizionale
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




	public static void main(String[] args) {
		int[] v = new int[] { 9, 5, 7, 6, 8, 3, 4, 1, 2 };
		QSortG qs = new QSortG();
		qs.sort(v);
		print(v);
		System.out.println();
		Random rnd = new Random();
		v = new int[100];
		for (int i = 0; i < 100; i++) {
			v[i] = rnd.nextInt(500);
		}
		qs.sort(v);
		print(v);

	}
}
