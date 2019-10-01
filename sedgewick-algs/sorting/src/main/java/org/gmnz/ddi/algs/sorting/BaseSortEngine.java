package org.gmnz.ddi.algs.sorting;

/**
 * BaseSortEngine
 */
class BaseSortEngine {

    protected void swap(Comparable<?>[] arr, int i, int j) {
        Comparable<?> temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    protected <K extends Comparable<K>> boolean less(K c1, K c2) {
        return c1.compareTo(c2) < 0;
    }

}