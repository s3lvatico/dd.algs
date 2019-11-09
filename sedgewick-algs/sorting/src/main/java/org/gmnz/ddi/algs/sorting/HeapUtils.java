package org.gmnz.ddi.algs.sorting;

/**
 * HeapUtils - operazioni base su un (max)heap.
 * <p>
 * Contiene le operazioni basilari definite per gli heap: swim e sink. Queste
 * operazioni sono poi usate nell'heapsort.
 * <p>
 * Ricorda sempre che in un heap la struttura dati principale è un array dove
 * l'indice 0 è vuoto o sostanzialmente ignorato. I dati significativi hanno
 * senso solo dall'indice 1.
 */
public class HeapUtils<K extends Comparable<K>> extends BaseSortEngine {

    /**
     * Fa emergere verso "l'alto" nell'array v l'elemento di indice i, rispettando
     * l'invariante del maxHeap
     * 
     * @param v array di elementi <code>K</code> {@link Comparable}
     * @param i indice dell'elemento da far emergere
     */
    public void swim(K[] v, int i) {
        // l'indice i punta sempre all'elemento che sto considerando nell'heap

        // finché non ho raggiunto la cima dell'heap (i>1) e l'elemento che sto
        // considerando è maggiore del suo genitore nell'albero
        while (i > 1 && less(v[i / 2], v[i])) {
            // scambia di posto i due elementi
            swap(v, i, i / 2);
            // aggiorna il puntatore all'elemento interessato
            i /= 2;
        }
    }

    /**
     * Fa affondare l'elemento i-esimo nell'array v, rispettando l'invariante del
     * maxHeap.
     * <p>
     * Si controlla ogni volta se l'elemento corrente è maggiore (attenzione) del
     * più grande dei suoi discendenti (se ne ha due). Si scambia quindi di posto
     * l'elemento corrente col maggiore dei suoi due discendenti.
     * 
     * @param v        array di elementi <code>K</code> {@link Comparable}
     * @param i        indice dell'elemento da far
     * @param heapSize dimensione corrente dell'heap
     */
    public void sink(K[] v, int i, final int heapSize) {
        // l'indice i viene aggiornato e (generalmente) fatto scorrere in direzione
        // della fine dell'heap, perciò è necessario sapere quanto è grande l'heap per
        // controllare di restare sempre al suo interno.

        // dovendo confrontare un elemento con i suoi diretti discendenti (i cui indici
        // distano dall'indice corrente per un fattore 2), si controlla che ci si trovi
        // sempre all'interno dell'heap
        while (2 * i <= heapSize) {
            // k è l'indice del primo discendente
            int k = 2 * i;

            // se l'elemento corrente ha due discendenti e il secondo
            // discendente è maggiore del primo...
            if (k < heapSize && less(v, k, k + 1))
                // k ora punta al maggiore dei due discendenti dell'elemento puntato da i
                k++;

            // se l'elemento corrente è minore del maggiore dei suoi discendenti
            if (less(v, i, k)) {
                // lo scambia di posto col discendente più grande
                // in questo modo v[i] contiene un elemento che è certamente maggiore di
                // entrambi i suoi discendenti
                swap(v, i, k);

                // aggiorna il puntatore di posizione in modo da indicare sempre l'elemento
                // inizialmente considerato
                i = k;
            } else
                // altrimenti si è in una condizione in cui l'invariante del maxHeap è già
                // rispettata, perciò ci si ferma
                break;
        }
    }

}