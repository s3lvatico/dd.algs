package org.gmnz.ddi.algs.sorting;


/**
 * HeapSort
 */
public class HeapSort<K extends Comparable<K>> {

    private HeapUtils<K> hu;
    private K[] v;

    @SuppressWarnings("unchecked")
    public HeapSort(K[] v) {
        this.v = (K[]) new Comparable[v.length + 1];
        int i = 1;
        for (K k : v) {
            this.v[i] = k;
            i++;
        }
        hu = new HeapUtils<>();
    }



    public void sort() {
        heapify();
        heapsort();
    }



    void heapify() {
        int heapSize = v.length - 1;
        for (int i = v.length / 2; i >= 1; i--) {
            hu.sink(v, i, heapSize);
        }
    }



    void heapsort() {
        int heapSize = v.length - 1;
        while (heapSize > 1) {
            hu.swap(v, 1, heapSize);
            hu.sink(v, 1, --heapSize);
        }
    }

    /*
     * l'heapsort si compone di due passaggi: 1) trasforma l'array in un maxheap
     * 2.1) scambia di posto la cima dell'heap con l'ultimo elemento 2.2) sink(1)
     * 2.3) restringi la dimensione dell'heap 2.4) ripeti finché la dimensione
     * dell'heap è >= 2
     */
    boolean isSorted() {
        return hu.isSorted(v, v.length-1);
    }

}

