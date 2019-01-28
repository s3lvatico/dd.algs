package org.gmnz.ddalg.sort.thrown;


import edu.princeton.cs.algs4.StdOut;


@Deprecated
public abstract class AbstractSortEngine {

	public abstract Comparable[] sort(Comparable[] a);



	/**
	 * confronta due valori comparabili
	 * 
	 * @param v primo
	 * @param w secondo
	 * @return true se il primo valore è strettamente minore del secondo
	 */
	protected boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}



	/**
	 * nell'array a, scambia gli elementi di posto i e j
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	protected void swap(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}



	protected void show(Comparable[] a) { // Print the array, on a single line.
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}



	public boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

}
