package org.gmnz.ddi.algs.pq2;


import java.util.NoSuchElementException;


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
        if (i >= 1 && j >= 1)
            return pq[i].compareTo(pq[j]) < 0;
        else
            return false;
    }



    private void swap(int x, int y) {
        K tmp = pq[x];
        pq[x] = pq[y];
        pq[y] = tmp;
    }



    /**
     * fa "emergere" se necessario l'elemento di posto <code>k</code>
     * 
     * @param k
     */
    private void swim(int k) {
        int i = k;
        /*
         * a partire dall'indice indicato si scansiona l'heap verso la cima,
         * controllando l'elemento (unico) di livello superiore. Trovandoci in un
         * maxheap, salendo di livello devo trovare elementi più grandi di quello
         * corrente. Se così non è eseguo uno scambio, mi sposto al livello superiore e
         * ri-eseguo lo stesso controllo, finché eventualmente non si arriva in cima
         * all'heap.
         */
        while (i > 0 && less(i / 2, i)) {
            swap(i, i / 2);
            i /= 2;
        }
    }



    /**
     * fa "sprofondare" se necessario l'elemento di posto <code>k</code>
     * 
     * @param k
     */
    private void sink(int k) {
        // scorro l'heap dal posto k verso il basso
        while (2 * k <= heapSize // finché esiste il livello successivo dell'heap
        ) {
            int j = 2 * k; // vado al livello successivo
            if (j < heapSize // essendo un maxheap binario ( == albero binario completo) ora mi trovo in uno
                             // dei due discendenti del nodo in cui mi trovavo prima. Devo determinare se
                             // scambiare o meno il nodo corrente con uno dei suoi discendenti. Ma i
                             // discendenti sono due. E' quindi necessario individuare il massimo tra i
                             // discendenti. Per far questo si controlla che la posizione corrente sia
                             // strettamente minore dell'indice massimo dell'heap (altrimenti sarei alla fine
                             // dell'heap e non ci sarebbero altri elementi da controllare)....

                    && less(j, j + 1)) // ...e che, in caso di esistenza di un secondo elemento, questo sia maggiore
                                       // del primo discendente. Se così è...
                j++; // ... si aggiorna l'indice del massimo tra i discendenti

            if (!less(k, j))
                // se la chiave da verificare è già maggiore o uguale del massimo tra i due
                // discendenti del nodo corrente, vuol dire che la chiave è già in posizione
                // corretta, quindi ci si ferma
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
        if (heapSize == pq.length)
            throw new UnsupportedOperationException("heap is full");
        // l'inserimento avviene inserendo il nuovo elemento in coda all'heap
        // e poi facendolo "emergere" per mantenere verificato l'invariante dell'heap
        pq[++heapSize] = key;
        swim(heapSize);
    }



    /**
     * ottiene l'elemento massimo di questo heap
     * 
     * @return
     */
    public K max() {
        if (isEmpty())
            throw new NoSuchElementException("heap is empty");
        // nel maxheap, il massimo sta sempre in cima al mucchio
        return pq[1];
    }



    /**
     * ottiene l'elemento massimo di questo heap e lo rimuove dall'heap stesso
     * 
     * @return
     */
    public K delMax() {
        /*
         * questa implementazione è pigra, nel senso che non pulisce il riferimento
         * all'elemento massimo dell'heap. Il massimo (i.e. la cima dell'heap) viene
         * scambiato di posto con l'elemento in fondo all'heap, poi la dimensione
         * dell'heap viene decrementata e poi si esegue un sink sulla cima dell'heap per
         * mantenere verificato l'invariante dell'heap.
         */
        K max = max();
        swap(1, heapSize);
        heapSize--;
        sink(1);
        return max;
    }
}