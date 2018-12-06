package org.gmnz.ddalg.sort;

/**
 * Struttura dati si immagina come un albero. Ogni nodo può essere AUT una
 * foglia AUT con discendenti la cui cardinalità è minore di quella del nodo
 * stesso. (in questo caso si parla di MAX-Heap, il valore massimo della
 * struttura è alla radice dell'albero, il caso duale è il MIN-Heap).
 * 
 * è un albero
 * <li>BINARIO : ogni nodo ha al più due discendenti
 * <li>COMPLETO : ogni livello è completo, eccetto al più l'ultimo Tipicamente
 * viene rappresentato "proiettandolo" su un array. Questo è possibile in forza
 * delle due caratterizzazioni dell'heap. In questo modo si fa sì che i
 * discendenti dell'elemento in posizione K si trovano rispettivamente in
 * posizione 2K+1 e 2K+2.
 * 
 * @author simone
 *
 */
public class Heap {

	/**
	 * Trasforma l'albero <code>arr</code> in un M-heap
	 * 
	 * @param arr
	 * @return
	 */
	public int[] maxHeapify(int[] arr) {
		int l = arr.length;
		for (int i = l / 2 - 1; i >= 0; i--) {
			maxHeapify(arr, l, i);
		}
		return arr;
	}



	/**
	 * Trasforma in heap il sottoalbero specificato.
	 * 
	 * Il sottoalbero è identificato a partire dall'indice specificato, e si
	 * specifica pure la grandezza dell'heap
	 * 
	 * @param arr     array che contiene l'albero
	 * @param width   grandezza dell'heap
	 * @param rootIdx radice dell'albero da trasformare in heap
	 * @return array di <code>int</code> la cui porzione compresa in [0, w-1] ha la
	 *         struttura di un heap
	 */
	public int[] maxHeapify(int[] arr, int width, int rootIdx) {
		// HP: l'indice rootIdx passato si riferisce al nodo con l'elemento massimo
		int maxIdx = rootIdx;

		// calcola gli indici dei due discendenti dell'elemento specificato
		int sx = 2 * rootIdx + 1;
		int dx = 2 * rootIdx + 2;

		// controlla se a questo indice corrisponde davvero un elemento di un heap
		// (i.e. i suoi discendenti, se esistono, sono di valore inferiore)
		if (sx < width && arr[sx] > arr[maxIdx]) {
			maxIdx = sx;
		}
		if (dx < width && arr[dx] > arr[maxIdx]) {
			maxIdx = dx;
		}

		// se questo non è un nodo di un heap, scambia il nodo corrente con quello
		// dell'indice trovato, poi (ri)verifica la proprietà di heap su questo nodo
		// (che ora contiene un massimo)
		if (maxIdx != rootIdx) {
			IntArrayUtils.swap(arr, rootIdx, maxIdx);
			arr = maxHeapify(arr, width, maxIdx);
		}
		// --

		return arr;
	}



	public int[] heapSort(int[] arr) {
		arr = maxHeapify(arr);
		for (int sortWindowWidth = arr.length - 1; sortWindowWidth >= 0; sortWindowWidth--) {
			IntArrayUtils.swap(arr, 0, sortWindowWidth);
			arr = maxHeapify(arr, sortWindowWidth, 0);
		}
		return arr;
	}

}
