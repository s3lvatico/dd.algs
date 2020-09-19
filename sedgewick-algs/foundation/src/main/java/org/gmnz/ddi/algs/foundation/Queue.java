package org.gmnz.ddi.algs.foundation;

/**
 * Interfaccia base della coda generica.
 * 
 * @param <K> il tipo degli elementi contenuti nella coda
 */
public interface Queue<K> {

    /**
     * Inserisce un nuovo elemento nella coda. Le implementazioni non dovrebbero
     * consentire l'inserimento di elementi con chiave nulla.
     * 
     * @param k
     */
    void insert(K k);

    /**
     * Controlla, senza rimuoverlo, il primo elemento della coda.
     * <p>
     * Se la coda è vuota, restituisce <code>null</code>.
     * 
     * @return l'elemento al primo posto nella coda, oppure <code>null</code> se la
     * coda è vuota.
     */
    K peek();

    /**
     * Estrae il primo elemento della coda, rimuovendolo dalla coda stessa.
     * <p>
     * Se la coda è vuota, restituisce <code>null</code>.
     * 
     * @return l'elemento al primo posto nella coda, oppure <code>null</code> se la
     * coda è vuota.
     */
    K poll();

    /**
     * Numero di elementi presenti nella coda.
     */
    int size();

}