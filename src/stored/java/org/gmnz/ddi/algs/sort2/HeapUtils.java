package org.gmnz.ddi.algs.sort2;


/**
 * HeapUtils - funzioni generiche su un heap
 * <p>
 * questa classe mi serve perché deve contenere funzionalità generiche da
 * applicare ai vari casi d'utilizzo di un heap (finora ho visto le code con
 * priorità e l'heapsort)
 */
public class HeapUtils<K extends Comparable<K>> {

    /**
     * scambia gli elementi di posto i e j nell'array v
     * 
     * @param v
     * @param i
     * @param j
     */
    public void swap(K[] v, int i, int j) {
        K tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;
    }



    /**
     * verifica che nell'array v l'elemento di posto i sia strettamente minore
     * dell'elemento di posto j
     * 
     * @param  i
     * @param  j
     * @return
     */
    public boolean less(K[] v, int i, int j) {
        return v[i].compareTo(v[j]) < 0;
    }



    /**
     * fa emergere l'elemento i-esimo dell'array v, rispettando l'invariante del
     * maxHeap
     */
    public void swim(K[] v, int i) {
        while (i > 1 && less(v, i / 2, i)) {
            swap(v, i / 2, i);
            i /= 2;
        }
    }



    /**
     * fa affondare l'elemento i-esimo nell'array v, rispettando l'invariante del
     * maxHeap
     * 
     * @param v
     * @param i
     * @param heapSize
     */
    public void sink(K[] v, int i, int heapSize) {
        while (2 * i <= heapSize) {
            int k = 2 * i;
            if (k < heapSize && less(v, k, k + 1))
                k++;
            if (less(v, i, k)) {
                swap(v, i, k);
                i = k;
            }
            else
                break;
        }
    }



    boolean isSorted(K[] v, int heapSize) {
        int i = 2;
        while (i <= heapSize) {
            if (less(v, i, i-1))
                return false;
            i++;
        }
        return true;
    }

}