package org.gmnz.ddi.algs.searching;

/**
 * Classica Symbol Table
 * 
 * @param <K> tipo della chiave
 * @param <V> tipo del valore associato alla chiave
 */
public interface SymbolTable<K, V> {

    /**
     * Associa una chiave ad un valore.
     * <p>
     * Tipicamente il valore dovrebbe essere non nullo. Le implementazioni
     * dovrebbero lanciare un'eccezione nel caso la chiave specificata fosse
     * {@code null}
     * 
     * @param key chiave da mappare
     * @param value valore associato alla chiave
     */
    void put(K key, V value);

    /**
     * Restituisce il valore associato alla chiave specificata, oppure
     * <code>null</code> se la chiave non è presente nella ST.
     * <p>
     * Le implementazioni dovrebbero lanciare un'eccezione nel caso si specificasse
     * una chiave nulla.
     * 
     * @param key chiave (non <code>null</code>)
     * @return il valore associato alla chiave specificata, oppure
     * <code>null</code>.
     */
    V get(K key);

    /**
     * Elimina una chiave dalla ST.
     * <p>
     * Di solito questa operazione consiste o nell'eliminazione vera e propria della
     * chiave dalla ST, o all'associazione del valore {@code null} alla chiave
     * specificata.
     * <p>
     * Le implementazioni dovrebbero lanciare un'eccezione nel caso si specificasse
     * una chiave nulla.
     * 
     * @param key la chiave da eliminare dalla ST
     */

    void delete(K key);

    /**
     * Controllo di appartenenza
     * 
     * @param key
     * @return {@code true} se la chiave specificata appartiene alla ST, altrimenti
     * {@code false}
     */
    boolean contains(K key);

    /**
     * Dimensione della ST: numero di chiavi mappate ad un valore non nullo
     * 
     * @return
     */
    int size();

    /**
     * @return {@code true} se la ST contiene almeno una chiave mappata ad un valore
     * non nullo, {@code false} altrimenti
     */
    boolean isEmpty();

    /**
     * Insieme delle chiavi, restituito come oggetto {@link Iterable}
     * 
     */
    Iterable<K> keys();
}