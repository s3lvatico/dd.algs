package org.gmnz.ddalg.sort;


import java.util.Comparator;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("rawtypes")
public class BasicSortEngine {

	public static void sort(Comparable[] a) {
		return;
	}



	public static void sort(Object[] a, Comparator comparator) {
		return;
	}



	// is v < w ?
	protected static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}



	// is v < w ?
	protected static boolean less(Comparator comparator, Object v, Object w) {
		return comparator.compare(v, w) < 0;
	}



	// exchange a[i] and a[j]
	protected static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}



	/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/

	// is the array a[] sorted?
	protected static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}



	// is the array sorted from a[lo] to a[hi]
	protected static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}



	// is the array a[] sorted?
	protected static boolean isSorted(Object[] a, Comparator comparator) {
		return isSorted(a, comparator, 0, a.length - 1);
	}



	// is the array sorted from a[lo] to a[hi]
	protected static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(comparator, a[i], a[i - 1]))
				return false;
		return true;
	}



	// print array to standard output
	protected static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}



	/**
	 * Reads in a sequence of strings from standard input; selection sorts them; and
	 * prints them to standard output in ascending order.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Selection.sort(a);
		show(a);
	}

}