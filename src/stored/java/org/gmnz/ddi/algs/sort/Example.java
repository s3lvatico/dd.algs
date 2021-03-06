package org.gmnz.ddi.algs.sort;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Example<T extends Comparable<T>> {

	public static <T extends Comparable<T>> void sort(T[] a) {
		/* See Algorithms 2.1, 2.2, 2.3, 2.4, 2.5, or 2.7. */ }



	private static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}



	@SuppressWarnings("unused")
	private static void exch(Comparable<?>[] a, int i, int j) {
		Comparable<?> t = a[i];
		a[i] = a[j];
		a[j] = t;
	}



	private static <T extends Comparable<T>> void show(T[] a) { // Print the array, on a single line.
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}



	public static <T extends Comparable<T>> boolean isSorted(T[] a) { // Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}



	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
