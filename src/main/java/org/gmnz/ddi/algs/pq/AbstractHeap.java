package org.gmnz.ddi.algs.pq;


import org.gmnz.ddi.algs.sort.AbstractSortEngine;


abstract class AbstractHeap<KEY extends Comparable<KEY>> extends AbstractSortEngine<KEY> {

	protected int n = 0;


	@SuppressWarnings("unchecked")
	AbstractHeap(int maxN) {
		super((KEY[]) new Comparable[maxN + 1]);
	}



	protected boolean less(int i, int j) {
		return less(a[i], a[j]);
	}



	/**
	 * fa "emergere" l'elemento all'indice specificato finché il suo ascendente è
	 * minore, o finché non si raggiunge la cima dell'heap
	 *
	 * @param k
	 */
	protected void swim(int k) {
		/*
		 * internamente al ciclo while, k verrà modificato in modo che punti a elementi
		 * che stanno via via più in alto nell'heap. Questo significa che verrà via via
		 * diviso per 2, e per come è organizzato l'heap significa andare via via verso
		 * l'ascendente del nodo puntato da k.
		 */
		while (k > 1 && less(k / 2, k)) {
			/*
			 * k > 1 strettamente significa che non ho ancora raggiunto la cima dell'heap
			 */
			/*
			 * se l'elemento a k/2 è minore di quello all'indice k significa che l'albero
			 * completo al momento non rispetta l'ipotesi di "heap", perciò devo scambiare
			 * l'elemento corrente con il suo ascendente
			 */
			swap(k, k / 2);
			/*
			 * dopo lo scambio, è possibile che l'elemento riposizionato violi ancora la
			 * condizione "heap", perciò si aggiorna l'indice che lo punta, e si ripete il
			 * controllo
			 */
			k = k / 2;
		}
	}



	/**
	 * "sprofonda" l'elemento all'indice specificato fino a ripristinare l'ipotesi
	 * "heap" nell'intera struttura
	 *
	 * @param k
	 */
	protected void sink(int k) {
		/*
		 * controlla se l'elemento indicato ha discendenti o meno. Per l'ipotesi di
		 * costruzione dell'heap sotto forma di albero completo, un elemento di indice
		 * "i" ha discendenti se e solo se esiste almeno l'elemento di indice "2*i"
		 */
		while (2 * k <= n) {
			// se l'elemento ha discendenti
			// considero l'indice del primo discendente
			int j = 2 * k;
			// se esiste anche il secondo discendente e questo è maggiore del discendente
			// correntemente indicato da j
			if (j < n && less(j, j + 1)) {
				// ora j punta al discendente di massimo valore tra quelli del nodo indicato
				j++;
			}
			// se il nodo indicato è minore di uno dei suoi discendenti
			if (less(k, j)) {
				// scambio il nodo indicato con il discendente trovato
				swap(k, j);
				// aggiorno il puntatore mantenendolo sul nodo che ho spostato ripetendo il
				// ciclo per verificare se la condizione di "heap" è ancora verificata nello
				// stato attuale
				k = j;
			}
			// il nodo indicato è maggiore di entrambi i suoi discendenti, quindi la
			// condizione di "heap" è verificata, pertanto interrompo il ciclo
			else {
				break;
			}
		}
	}

}
