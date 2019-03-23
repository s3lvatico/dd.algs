package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.In;


public class MergeSortTopDown<KEY extends Comparable<KEY>> extends AbstractMergeSort<KEY> {

	protected MergeSortTopDown(KEY[] arr) {
		super(arr);
	}




	@Override
	public void sort() {
		sort(0, arrayLength - 1);
	}




	/**
	 * Ordinamento vero e proprio.
	 * <p>
	 * Se gli indici lo e hi coincidono o si incrociano, si ferma la ricorsione.
	 * Altrimenti viene individuato un indice "di mezzo" e viene richiamato questo
	 * stesso metodo con i due subarray tra <code>[lo..mid]</code> e
	 * <code>[mid+1..hi]</code>. Quando gli array non sono ulteriormente
	 * suddivisibili si esegue il <code>merge</code> delle due parti individuate,
	 * che ricreerà un subarray ordinato.
	 *
	 * @param lo
	 * @param hi
	 */
	private void sort(int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		sort(lo, mid);
		sort(mid + 1, hi);
		merge(lo, mid, hi);
	}




	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = new In(args[0]).readAllStrings();
		MergeSortTopDown sortEngine = new MergeSortTopDown(a);
		sortEngine.sort();
		sortEngine.show();
	}

}
