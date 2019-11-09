package org.gmnz.ddi.algs.sorting;

/**
 * HeapSort
 */
public class HeapSort<K extends Comparable<K>> {

    private HeapUtils<K> hu;
    private K[] heap;

    @SuppressWarnings("unchecked")
    public HeapSort(K[] v) {
        // crea l'heap interno (array base 1)
        this.heap = (K[]) new Comparable[v.length + 1];

        // ci trasferisce i contenuti dell'array originario
        int i = 1;
        for (K k : v) {
            this.heap[i] = k;
            i++;
        }

        // init dipendenze
        hu = new HeapUtils<>();
    }

    /**
     * Consiste di due passi principali
     * <p>
     * <ul>
     * <li>trasformazione dell'array in un heap
     * <li>heapsort vero e proprio
     * </ul>
     * Infine restituisce un array di lunghezza pari a quella dell'array iniziale, ottenuto
     * dall'heap.
     * 
     * @return array di {@link Comparable} ordinato
     */
    public K[] sort() {
        heapify();
        heapsort();

        //
        K[] sortedArray = (K[]) new Comparable[heap.length - 1];
        for (int i = 1; i < heap.length; i++) {
            sortedArray[i - 1] = heap[i];
        }
        return sortedArray;
    }

    /**
     * Trasforma l'array interno in un heap vero e proprio.
     * <p>
     * Dovendo far "affondare" gli elementi, conviene partire da metà array, in modo che le
     * operazioni inizino a partire dal penultimo livello dell'albero binario (non ha senso iniziare
     * dal fondo, perché non ci sono elementi che possono affondare)
     */
    void heapify() {
        int heapSize = heap.length - 1;
        for (int i = heap.length / 2; i >= 1; i--) {
            hu.sink(heap, i, heapSize);
        }
    }

    /**
     * 
     */
    void heapsort() {
        int heapSize = heap.length - 1;
        while (heapSize > 1) {
            hu.swap(heap, 1, heapSize);
            hu.sink(heap, 1, --heapSize);
        }
    }

    /*
     * l'heapsort si compone di due passaggi: 1) trasforma l'array in un maxheap 2.1) scambia di
     * posto la cima dell'heap con l'ultimo elemento 2.2) sink(1) 2.3) restringi la dimensione
     * dell'heap 2.4) ripeti finché la dimensione dell'heap è >= 2
     */

}
