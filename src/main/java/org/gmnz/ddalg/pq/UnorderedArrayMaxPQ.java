package org.gmnz.ddalg.pq;

/**
 * UnorderedArrayMaxPQ
 */
public class UnorderedArrayMaxPQ<KEY extends Comparable<KEY>> {

    /** l'array non ordinato */
    private KEY[] pq;

    /** dimensione della pq */
    private int n;

    public UnorderedArrayMaxPQ(int capacity) {
        pq = (KEY[]) new Comparable[capacity];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(KEY k) {
        pq[n++] = k;
    }

    public KEY delMax() {
        int max = 0; // indice dell'elemento max
        for (int i = 1; i < n; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        // determinato il massimo, lo mette all'ultimo posto
        swap(max, n - 1);
        // fornisce l'ultimo elemento della pq e ne decrementa la dimensione
        return pq[--n];
    }

    // metodi helper

    /** dice se l'elemento di posto i è strettamente minore di quello nel posto j */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /** scambia di posto nella coda gli elementi di posto i, j */
    private void swap(int i, int j) {
        KEY temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

}