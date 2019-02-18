package org.gmnz.ddalg.sort;


import edu.princeton.cs.algs4.StdOut;


/**
 * base dei motori di sort
 *
 * @author gemini
 *
 */
public abstract class AbstractSortEngine<KEY extends Comparable<KEY>> {

	protected KEY[] a;
	protected int arrayLength;



	/**
	 * inizializza il motore con l'array specificato. Gestisce i parametri nulli
	 * creando un array fittizio di dimensione 1
	 *
	 * @param arr
	 */
	protected AbstractSortEngine(KEY[] arr) {
		if (arr == null) {
			this.a = (KEY[]) new Comparable[] {};
		} else {
			this.a = arr;
		}
		arrayLength = a.length;
	}



	protected abstract void sort();



	/**
	 * scambia nell'array interno gli elementi in posizione i e j
	 *
	 * @param i
	 * @param j
	 */
	protected void swap(int i, int j) {
		KEY temp = a[i];
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
	protected boolean less(KEY x, KEY y) {
		return x.compareTo(y) < 0;
	}



	/**
	 * verifica che l'array interno sia completamente ordinato, i.e. se ogni
	 * elemento è maggiore o uguale al precedente
	 *
	 * @return
	 */
	protected boolean isSorted() {
		if (arrayLength < 2) {
			return true;
		} else {
			for (int i = 0; i < arrayLength - 1; i++) {
				if (less(a[i + 1], a[i])) {
					return false;
				}
			}
			return true;
		}
	}



	protected void show() {
		if (a.length > 0) {
			for (int i = 0; i < arrayLength; i++) {
				StdOut.print(a[i] + " ");
			}
			StdOut.println();
		} else {
			StdOut.println("<empty array>");
		}
	}
}
