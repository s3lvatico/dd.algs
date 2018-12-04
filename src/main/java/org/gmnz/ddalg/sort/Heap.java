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
	 * Trasforma l'albero <code>v</code> in un M-heap
	 * 
	 * @param v
	 * @return
	 */
	public int[] maxHeapify(int[] v) {
		int l = v.length;
		for (int i = v.length / 2 - 1; i >= 0; i--) {
			maxHeapify(v, l, i);
		}
		return v;
	}



	/**
	 * Trasforma in heap il sottoalbero specificato.
	 * 
	 * Il sottoalbero è identificato a partire dall'indice specificato, e si
	 * specifica pure la grandezza dell'heap
	 * 
	 * @param v       array che contiene l'albero
	 * @param w       grandezza dell'heap
	 * @param rootIdx radice dell'albero da trasformare in heap
	 * @return array di <code>int</code> la cui porzione compresa in [0, w-1] ha la
	 *         struttura di un heap
	 */
	public int[] maxHeapify(int[] v, int w, int rootIdx) {
		int max = rootIdx;
		int sx = 2 * rootIdx + 1;
		int dx = 2 * rootIdx + 2;

		if (sx < w && v[sx] > v[max]) {
			max = sx;
		}
		if (dx < w && v[dx] > v[max]) {
			max = dx;
		}
		if (max != rootIdx) {
			int tmp = v[rootIdx];
			v[rootIdx] = v[max];
			v[max] = tmp;

			v = maxHeapify(v, w, max);
		}
		return v;
	}



	public int[] heapSort(int[] v) {
		v = maxHeapify(v);
		
		for (int i = v.length-1; i >= 0; i--) {
			int tmp = v[0];
			v[0] = v[i];
			v[i] = tmp;

			v = maxHeapify(v, i, 0);
		}
		return v;
	}

}
