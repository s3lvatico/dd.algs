package org.gmnz.ddi.algs.pq2;


/**
 * Classe base di gestione degli array con elementi comparabili.
 */
class ComparablesArrayManager<K extends Comparable<K>> {

    protected K[] v;

    /**
     * vero <==> l'elemento di posto <code>i</code> è strettamente minore
     * dell'elemento di posto <code>j</code>
     */
    protected boolean less(int i, int j) {
        return v[i].compareTo(v[j]) < 0;
    }



    /**
     * scambia tra loro gli elementi di posto <code>i</code> e <code>j</code>
     */
    void swap(int i, int j) {
        K temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

}