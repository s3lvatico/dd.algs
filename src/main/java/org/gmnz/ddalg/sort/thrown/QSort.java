package org.gmnz.ddalg.sort.thrown;


import edu.princeton.cs.algs4.In;


public class QSort extends AbstractSortEngine {

	@Override
	public Comparable[] sort(Comparable[] a) {
		return sort(a, 0, a.length - 1);
	}



	private Comparable[] sort(Comparable[] a, int lo, int hi) {
		int j = partition(a, lo, hi);
		a = sort(a, lo, j - 1);
		a = sort(a, j + 1, hi);
		return a;
	}



	/**
	 * è proprio questo metodo che di fatto esegue l'ordinamento. Deve trovare e
	 * restituire l'indice di un elemento che sia già in ordine nell'array finale.
	 * Inoltre, questo metodo riposiziona il contenuto dell'array (nei limiti
	 * indicati).
	 * <p>
	 * Identifica un indice j tale che: 1) l'elemento a[j] è già nella giusta
	 * posizione nell'array ordinato, 2) tutti gli elementi in [lo..j-1] precedono
	 * a[j], 3) tutti gli elementi in [j+1..hi] seguono a[j]
	 * 
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	private int partition(Comparable[] a, int lo, int hi) {
		// fissa gli indici scorrevoli
		int i = lo;
		int j = hi + 1;
		// fissa il pivot
		Comparable v = a[lo];

		// scansione
		while (true) {
			// scorre l'indice dei minimi verso dx finché questo indica valori minori del
			// pivot
			while (less(a[++i], v)) {
				// ma si ferma comunque se raggiunge l'estremo dx dell'array
				if (i == hi)
					break;
			}
			// scorre l'indice dei massimi verso sx finché questo indica valori maggiori del
			// pivot
			while (less(v, a[--j])) {
				// ma si ferma comunque se raggiunge l'estremo sx dell'array
				if (j == lo)
					break;
			}
			// se gli indici di scorrimento si sono incrociati allora non ci sono più
			// controlli da fare
			if (i >= j)
				break;
			else
				// altrimenti scambia di posto gli elementi indicati da i,j, che sono "fuori
				// posto" rispetto al pivot
				swap(a, i, j);
		}
		// quando gli indici di scansione si sono incrociati si posiziona il pivot dove
		// effettivamente deve stare
		// poiché gli indici si sono incrocia, è sicuramente a[j] <= pivot
		swap(a, lo, j);
		// restituisce l'indice del pivot
		return j;
	}



	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In(args[0]).readAllStrings();
		AbstractSortEngine sortEngine = new QSort();
		a = (String[]) sortEngine.sort(a);
		assert sortEngine.isSorted(a);
		sortEngine.show(a);
	}

}
