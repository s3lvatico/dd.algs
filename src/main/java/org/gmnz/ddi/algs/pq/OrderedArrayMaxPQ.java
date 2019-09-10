package org.gmnz.ddi.algs.pq;


/**
 * OrderedArrayMaxPQ
 */
public class OrderedArrayMaxPQ<KEY extends Comparable<KEY>> {

    /** l'array non ordinato */
    private KEY[] pq;

    /** dimensione della pq */
    private int n;

    @SuppressWarnings("unchecked")
    public OrderedArrayMaxPQ(int capacity) {
        pq = (KEY[]) new Comparable[capacity];
        n = 0;
    }



    public boolean isEmpty() {
        return n == 0;
    }



    public int size() {
        return n;
    }



    public void insert(KEY key) {
        int i = n - 1;
        while (i >= 0 && less(key, pq[i])) {
            pq[i + 1] = pq[i];
            i--;
        }
        pq[i + 1] = key;
        n++;
    }



    public KEY delMax() {
        return pq[--n];
    }

    // metodi helper



    /** dice se l'elemento di posto i è strettamente minore di quello nel posto j */
    private boolean less(KEY i, KEY j) {
        return i.compareTo(j) < 0;
    }

}