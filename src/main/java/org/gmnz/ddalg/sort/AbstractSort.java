package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.StdOut;


/**
 * base dei motori di sort
 * 
 * @author gemini
 *
 */
abstract class AbstractSort {

	protected Comparable[] a;



	/**
	 * inizializza il motore con l'array specificato. Gestisce i parametri nulli
	 * creando un array fittizio di dimensione 1
	 * 
	 * @param arr
	 */
	protected AbstractSort(Comparable[] arr) {
		if (arr == null) {
			this.a = new Comparable[] {};
		}
		else {
			this.a = arr;
		}
	}



	protected abstract void sort();



	/**
	 * scambia nell'array interno gli elementi in posizione i e j
	 * 
	 * @param i
	 * @param j
	 */
	protected void swap(int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}



	/**
	 * controlla che un elemento sia strettamente minore di un altro
	 * 
	 * @param x
	 * @param y
	 * @return <code>true</code> se x < y
	 */
	protected boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}



	/**
	 * verifica che l'array interno sia completamente ordinato, i.e. se ogni
	 * elemento è maggiore o uguale al precedente
	 * 
	 * @return
	 */
	protected boolean isSorted() {
		if (a.length == 0) {
			return true;
		}
		else {
			for (int i = 0; i < a.length - 1; i++) {
				if (less(a[i + 1], a[i])) {
					return false;
				}
			}
			return true;
		}
	}



	protected void show(Comparable[] a) {
		if (a.length == 0) {
			StdOut.println("<empty array>");
		}
		else {
			for (int i = 0; i < a.length; i++)
				StdOut.print(a[i] + " ");
			StdOut.println();
		}
	}
}
