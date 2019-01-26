package org.gmnz.ddalg.pq;


public class MaxPQ<KEY extends Comparable<KEY>> {

	private KEY[] pq;
	private int n = 0;



	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}



	private void swap(int i, int j) {
		KEY temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}



	public MaxPQ(int maxN) {
		pq = (KEY[]) new Comparable[maxN + 1];
	}



	public boolean isEmpty() {
		return n == 0;
	}



	public int size() {
		return n;
	}



	/**
	 * fa "emergere" l'elemento all'indice specificato finché il suo ascendente è
	 * minore, o finché non si raggiunge la cima dell'heap
	 * 
	 * @param k
	 */
	private void swim(int k) {
		/*
		 * internamente al ciclo while, k verrà modificato in modo che punti a elementi
		 * che stanno via
		 * via più in alto nell'heap. Questo significa che verrà via via diviso per 2, e
		 * per come è organizzato l'heap significa andare via via verso l'ascendente del
		 * nodo puntato da k.
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
	private void sink(int k) {
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



	/**
	 * Inserisce un elemento nuovo nella PQ.
	 * <p>
	 * Operativamente significa inserirlo in fondo alla PQ e poi ri-heapify la PQ in
	 * modo da mantenere l'ipotesi heap
	 * 
	 * @param v
	 */
	public void insert(KEY v) {
		pq[++n] = v;
		swim(n);
	}



	/**
	 * Rimuove l'elemento di maggior valore dalla PQ.
	 * <p>
	 * Il valore massimo è quello che è in cima ad ogni possibile percorso
	 * dell'albero binario completo, ossia la radice dell'albero. Operativamente si
	 * scambia la radice dell'albero con l'ultimo elemento dell'albero, si rimuove
	 * quest'ultimo e poi si re-heapify la struttura facendo "affondare" l'elemento
	 * ora radice al suo posto reale, per ripristinare l'ipotesi "heap".
	 * 
	 * @return
	 */
	public KEY dequeMax() {
		KEY max = pq[1];
		swap(1, n--);
		pq[n + 1] = null;
		sink(1);
		return max;
	}

}
