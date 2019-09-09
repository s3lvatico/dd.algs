package org.gmnz.ddi.algs.pq2;


/**
 * MaxHeapPQ
 */
public class MaxHeapPQ<K extends Comparable<K>> {

    private static final int DEFAULT_HEAP_SIZE = 16;
    private K[] pq; // array 1-based
    private int heapSize;

    @SuppressWarnings("unchecked")
    public MaxHeapPQ(int maxHeapSize) {
        if (maxHeapSize < 1)
            maxHeapSize = DEFAULT_HEAP_SIZE;
        pq = (K[]) new Comparable[maxHeapSize + 1];
        heapSize = 0;
    }



    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }



    private void swap(int x, int y) {
        K tmp = pq[x];
        pq[x] = pq[y];
        pq[y] = tmp;
    }



    private void swim(int k) {
        int i = k;
        while (i > 0 && less(i / 2, i)) {
            swap(i, i / 2);
            i /= 2;
        }
    }



    private void sink(int k) {
        while (2 * k <= heapSize // posso scendere di un livello?
        ) {
            int j = 2 * k;
            if (j < heapSize // j deve essere strettamente minore di heapSize, altrimenti
                    // significa che j indica l'ultimissima foglia dell'albero
                    // -- se così non è, devo controllare comunque l'elemento successivo
                    // (che a questo punto di certo rappresenta l'ultima foglia dell'albero)
                    // sia eventualmente maggiore di quello che sto considerando.
                    // Così facendo, se devo eseguire uno scambio, ho la certezza che
                    // nella posizione di arrivo ci sarà sempre l'elemento maggiore della terna
                    // mantenendo così l'invariante dell'"heap"
                    && less(j, j + 1))
                j++;

            if (!less(k, j))
                // se la chiave da verificare è già maggiore o uguale del massimo tra i due
                // discendenti
                // del nodo corrente, vuol dire che la chiave è già in posizione corretta,
                // quindi ci si ferma
                break;
            // altrimenti si scambia di posto
            swap(k, j);
            // e si aggiorna il puntatore di posizione
            k = j;
        }
    }



    public int size() {
        return heapSize;
    }



    public boolean isEmpty() {
        return heapSize == 0;
    }



    public void insert(K key) {
        pq[++heapSize] = key;
        swim(heapSize);
    }



    public K max() {
        return pq[1];
    }



    public K delMax() {
        K max = max();
        swap(1, heapSize);
        heapSize--;
        sink(1);
        return max;
    }
}