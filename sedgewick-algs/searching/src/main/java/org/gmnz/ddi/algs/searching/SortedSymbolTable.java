package org.gmnz.ddi.algs.searching;

/**
 * Estensione della {@link SymbolTable} in cui le chiavi sono ordinate.
 * <p>
 * Espone metodi addizionali che modellano le varie operazioni sulle chiavi.
 * 
 * @param <K> tipo della chiave ( che sia {@link Comparable} )
 * @param <V> tipo del valore associato alla chiave
 */
public interface SortedSymbolTable<K extends Comparable<K>, V> extends SymbolTable<K, V> {

    /**
     * @return la chiave più piccola, i.e. quella tale che ogni altra chiave della
     * tabella gli è maggiore
     */
    K min();

    /**
     * @return la chiave più grande, i.e. quella tale che ogni altra chiave della
     * tabella gli è minore.
     */
    K max();

    /**
     * @return la maggiore tra tutte le chiavi minori o uguali a {@code key}
     */
    K floor(K key);

    /**
     * @return la minore tra tutte le chiavi minori o uguali a {@code key}
     */
    K ceiling(K key);

    /**
     * Rango. Nell'insieme ordinato delle chiavi, determina il numero di chiavi che
     * precedono la chiave specificata (i.e. quelle che le sono strettamente
     * minori).
     * <p>
     * Nota che non è necessario che la chiave specificata si trovi effettivamente
     * nella ST, quindi {@code rank()} fornisce effettivamente la posizione che la
     * chiave specificata <i>dovrebbe</i> avere se si trovasse nella tabella.
     * 
     * @return il numero di chiavi minori di {@code key}
     */
    int rank(K key);

    /**
     * Selezione
     * 
     * @return la chiave di rango {@code r}
     */
    K select(int r);

    /**
     * Eliminazione della chiave più piccola
     */
    void deleteMin();

    /**
     * Eliminazione della chiave più grande
     */
    void deleteMax();

    /**
     * 
     * Numero di chiavi tra {@code lo} e {@code hi}
     */
    int size(K lo, K hi);

    /**
     * <i>Range query</i>.
     * <p>
     * Insieme ordinato delle chiavi in {@code [lo..hi]}
     */
    Iterable<K> keys(K lo, K hi);

    // keys() verrà ridefinito in modo da fornire un insieme ordinato
}