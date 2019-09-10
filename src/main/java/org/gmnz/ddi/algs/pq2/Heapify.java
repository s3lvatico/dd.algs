package org.gmnz.ddi.algs.pq2;

/**
 * Heapify
 */
class Heapify<K extends Comparable<K>> {

    void swim(K[] arr, int n) {
        while (n > 1 && less(arr, n / 2, n)) {
            swap(arr, n / 2, n);
            n /= 2;
        }
    }

    boolean less(K[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private void swap(K[] arr, int i, int j) {
        K temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
