package org.gmnz.ddi.algs.searching;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractSortedSymbolTable<K, V> {

   /**
    * radice del BST
    */
   private Node root;

   /**
    * Incapsula il nodo dell'albero.
    * <p>
    * Mantiene la chiave della ST, il valore corrispondente e i riferimenti ai
    * sottoalberi sinistro e destro.
    */
   private class Node {

      private K key;
      private V value;
      /**
       * sottoalbero sinistro
       */
      private Node left;
      /**
       * sottoalbero destro
       */
      private Node right;
      /**
       * numero di nodi di questo sottoalbero (questo nodo incluso)
       */
      private int n;

      Node(K key, V value, int n) {
         this.key = key;
         this.value = value;
         this.n = n;
      }



      @Override
      public String toString() {
         StringBuilder sb = new StringBuilder("(");
         sb.append(key.toString()).append(", ");
         sb.append(value.toString()).append(")");
         return sb.toString();
      }
   }

   private int size(Node x) {
      return x == null ? 0 : x.n;
   }



   @Override
   public int size() {
      // la dimensione dell'albero è pari alla dimensione del sottoalbero che inizia
      // alla radice dell'albero stesso
      return size(root);
   }



   /**
    * Cerca la chiave {@code key} attraversando l'albero a partire dal nodo
    * {@code x}.
    * 
    * @param x nodo in cui cercare
    * @param key chiave
    * @return il Node che contiene la chiave, altrimenti {@code null}
    */
   private Node get(Node x, K key) {
      if (x == null)
         return null;
      int cmp = key.compareTo(x.key);
      // se la chiave cercata è più piccola di quella del nodo corrente
      if (cmp < 0)
         // cerca nel sottoalbero sinistro
         return get(x.left, key);
      else
         // se la chiave cercata è più grande di quella del nodo corrente
         if (cmp > 0)
            // cerca nel sottoalbero destro
            return get(x.right, key);
         else
            // altrimenti la chiave cercata è proprio nel nodo corrente
            return x;
   }



   @Override
   public V get(K key) {
      checkNullKey(key);
      Node x = get(root, key);
      return x != null ? x.value : null;
   }



   /**
    * Inserisce nell'albero la chiave e il valore specificati, a partire dal nodo
    * specificato, mantenendo la proprietà del BST. Se la chiave è presente nel BST
    * ne sostituisce il valore.
    * 
    * @param x nodo da controllare per l'inserimento
    * @param key chiave
    * @param value valore
    * @return il nodo il cui valore è stato aggiornato, se la chiave è già presente
    * nel BST, altrimenti restituisce il nuovo nodo creato.
    */
   private Node put(Node x, K key, V value) {
      // se il nodo da controllare è nullo
      if (x == null)
         // crea un nuovo nodo (foglia) per l'albero, con chiave e valore indicati, e
         // dimensione 1
         return new Node(key, value, 1);

      // (nodo non nullo) - confronta la chiave specificata con la chiave nel nodo
      int cmp = key.compareTo(x.key);
      // se la chiave è minore di quella nel nodo
      if (cmp < 0)
         // aggiorna/crea da qualche parte nel sottoalbero sinistro
         x.left = put(x.left, key, value);
      else
         // altrimenti, se la chiave è maggiore di quella del nodo
         if (cmp > 0)
            // aggiorna/crea da qualche parte nel sottoalbero destro
            x.right = put(x.right, key, value);
         else
            // altrimenti (la chiave specificata esiste nel BST), aggiorna il valore a
            // quello specificato
            x.value = value;
      // eseguita l'aggiunta o l'aggiornamento, aggiorna la dimensione di questo nodo
      x.n = 1 + size(x.left) + size(x.right);
      // restituisce questo nodo
      return x;
   }



   @Override
   public void put(K key, V value) {
      checkNullKey(key);
      root = put(root, key, value);
   }



   /**
    * trova il nodo contenente la chiave minima del BST - ricorsivo
    * 
    * @param x nodo (mai null)
    * @return nodo contenente la chiave minima del BST
    */
   private Node min(Node x) {
      // se esiste il sottoalbero sinistro, la chiave minima si trova lì, altrimenti
      // si è già in fondo al sottoalbero sinistro
      return x.left == null ? x : min(x.left);
   }



   @Override
   public K min() {
      // BST vuoto ==> non c'è minimo
      if (root == null)
         return null;
      // altrimenti il minimo è nell'ultima foglia del sottoalbero sinistro
      return min(root).key;
   }



   /**
    * trova il nodo contenente la chiave massima del BST - ricorsivo
    * 
    * @param x nodo (mai null)
    * @return nodo contenente la chiave massima del BST
    */
   private Node max(Node x) {
      // se non c'è un sottoalbero destro siamo già in fondo, altrimenti si cerca
      // ricorsivamente nel sottoalbero destro
      return x.right == null ? x : max(x.right);
   }



   @Override
   public K max() {
      // BST vuoto ==> non c'è massimo
      if (root == null)
         return null;
      // altrimenti il massimo è nell'ultima foglia del sottoalbero destro
      return max(root).key;
   }

   /*
    * Se la chiave è minore della chiave di un nodo, il suo floor *deve* essere nel
    * sottoalbero sinistro. Se la chiave è maggiore della chiave di un nodo, il suo
    * floor *può* essere nel sottoalbero destro, ma solo se tale sottoalbero
    * contiene una chiave minore o uguale a quella specificata. Se c'è uguaglianza
    * tra le chiavi allora il floor è identificato.
    */



   /**
    * 
    * @param x
    * @param key chiave (mai null)
    * @return
    */
   private Node floor(Node x, K key) {
      // se il nodo è nullo
      if (x == null)
         // torna nullo
         return null;
      int cmp = key.compareTo(x.key);
      // se la chiave è minore di quella del nodo
      if (cmp < 0)
         // l'inf è nel sottoalbero sinistro
         return floor(x.left, key);
      else
         // se la chiave è uguale a quella del nodo
         if (cmp == 0)
            // l'inf è nel nodo stesso (è la sua chiave)
            return x;
         else {
            // la chiave è maggiore di quella del nodo, quindi controllo se esiste nel
            // sottoalbero destro una chiave minore di quella specificata
            Node t = floor(x.right, key);
            // se esiste, l'inf è il nodo trovato, altrimenti è in questo stesso nodo
            return t != null ? t : x;
         }

   }



   @Override
   public K floor(K key) {
      checkNullKey(key);
      Node x = floor(root, key);
      return x == null ? null : x.key;
   }



   /**
    * 
    * @param x
    * @param key chiave (mai null)
    * @return
    */
   private Node ceiling(Node x, K key) {
      // se il nodo è nullo
      if (x == null)
         // torna nullo
         return null;
      int cmp = key.compareTo(x.key);
      // se la chiave è più piccola di quella in questo nodo
      if (cmp < 0) {
         // ==> la chiave di questo nodo è un estremante per la chiave corrente
         // la chiave corrente è più piccola, quindi il sup lo cerco nel sottoalbero
         // sinistro, perché potrebbe esserci una chiave minore della chiave di questo
         // nodo purtuttavia un estremante per la chiave corrente.
         Node t = ceiling(x.left, key);
         // se il minimo degli estremanti non è nel sottoalbero sinistro, restituisco la
         // chiave di questo nodo
         return t != null ? t : x;
      } else
         if (cmp == 0)
            return x;
         else // la chiave di questo nodo è un minorante per la chiave specificata ==> cerco
              // nel sottoalbero destro
            return ceiling(x.right, key);
   }



   @Override
   public K ceiling(K key) {
      checkNullKey(key);
      Node x = ceiling(root, key);
      return x == null ? null : x.key;
   }



   /**
    * Trova il nodo di rango specificato a partire da un certo nodo.
    * <p>
    * Meotod ricorsivo sulla base della dimensione del sottoalbero sx del nodo
    * corrente.
    * 
    * @param x nodo corrente
    * @param r rango richiesto (per ipotesi >= 0)
    * @return il nodo la cui chiave ha esattamente {@code r} chiavi precedenti,
    * oppure {@code null}
    */
   private Node select(Node x, int r) {
      // se questo nodo non esiste restituisce null
      if (x == null)
         return null;
      // determina la dimensione del sottoalbero sx
      int t = size(x.left);
      // la dimensione è pari al rango specificato ==> esistono esattamente r
      // chiavi prima della chiave corrente
      if (t == r)
         // search hit
         return x;
      // altrimenti, se nel sottoalbero sx ci sono più di r chiavi
      else
         if (t > r)
            // si continua la ricerca nel sottoalbero sx
            return select(x.left, r);
         else
            // altrimenti si cerca nel sottoalbero dx la chiave che ha dimensione pari al
            // numero di chiavi mancanti, che sono esattamente r - (t+1)
            return select(x.right, r - t - 1);
   }



   @Override
   public K select(int r) {
      if (r < 0)
         throw new IllegalArgumentException();
      Node x = select(root, r);
      return x != null ? x.key : null;
   }



   /**
    * Rango di una chiave, da ricercare nel nodo corrente (ricorsivo).
    * 
    * @param x nodo corrente
    * @param key chiave di cui trovare il rango (per ipotesi non nulla)
    * @return rango della chiave (intero non negativo)
    */
   private int rank(Node x, K key) {
      // se il nodo corrente è nullo non esiste alcuna chiave minore di quella
      // specificata
      if (x == null)
         // ==> torna 0
         return 0;
      // confronta la chiave con quella del nodo corrente
      int cmp = key.compareTo(x.key);
      // se la chiave è più piccola di quella del nodo corrente
      if (cmp < 0)
         // cerco il rango nel sottoalbero sx
         return rank(x.left, key);
      else
         if (cmp == 0) // search hit
            // la dimensione del sottoalbero sx dice esattamente quante chiavi nell'albero
            // sono strettamente minori di quella considerata ==> definizione esatta di
            // rango
            return size(x.left);
         else // cmp > 0 ==> la chiave è maggiore di quella nel nodo corrente
              // cerco il rango nel sottoalbero dx; il rango sarà almeno pari a
              // rank(chiave-di-questo-nodo) + 1
            return size(x.left) + 1 + rank(x.right, key);

   }



   @Override
   public int rank(K key) {
      checkNullKey(key);
      return rank(root, key);
   }



   /**
    * per recuperare le chiavi in ordine si attraversa l'albero con la strategia
    * IN-ORDER (sottoalbero sx - radice - sottoalbero dx). L'elaborazione del nodo
    * consiste nel controllare se la sua chiave è compresa nell'intervallo
    * richiesto e, in caso positivo, aggiungerla alla coda.
    * 
    * @param x nodo corrente
    * @param lo estremo sx
    * @param hi estremo dx
    * @param q coda in cui inserire le chiavi
    */
   private void keys(Node x, K lo, K hi, Queue<K> q) {
      // terminazione della ricorsione; nodo nullo ==> return
      if (x == null)
         return;
      // confronta gli estremi con il nodo corrente
      int cmpLo = lo.compareTo(x.key);
      int cmpHi = hi.compareTo(x.key);
      if (cmpLo < 0) // attraversamento in-order ==> prima a sx
         keys(x.left, lo, hi, q);
      // poi il nodo
      if (cmpLo <= 0 && cmpHi >= 0)
         q.add(x.key);
      if (cmpHi > 0)
         keys(x.right, lo, hi, q);
   }



   @Override
   public Iterable<K> keys(K lo, K hi) {
      checkNullKey(lo);
      checkNullKey(hi);
      Queue<K> q = new LinkedList<>();
      keys(root, lo, hi, q);
      return q;
   }



   @Override
   public Iterable<K> keys() {
      if (isEmpty())
         return new HashSet<>();
      return keys(min(), max());
   }



   /**
    * Attraversa ricorsivamente l'albero fino a trovare il nodo che contiene la
    * chiave minima, e la elimina dall'albero.
    * <p>
    * Controlla l'esistenza del sottoalbero sx e se esiste esegue la chiamata
    * ricorsiva su di esso, altrimenti restituisce il sottoalbero dx del nodo
    * corrente.
    * 
    * @param x nodo corrente, nella chiamata ricorsiva
    * @return il sottoalbero destro del nodo corrente, oppure {@code null}
    */
   private Node deleteMin(Node x) {
      // se il nodo corrente è nullo
      if (x == null)
         // restituisce nullo
         return null;
      // se c'è un sottoalbero sx
      if (x.left != null) {
         // l'elemento minimo si trova nel sottoalbero sx ==> aggiorna il nodo puntato a
         // sinistra
         x.left = deleteMin(x.left);
         // e aggiorna la dimensione di questo sottoalbero
         x.n = 1 + size(x.left) + size(x.right);
         // restituisce questo nodo per mantenere la ricorsività
         return x;
      } else
         // poiché non esiste un sottoalbero sx, questo nodo è il nodo con la chiave
         // minima dell'albero. Tuttavia non è detto che questo nodo abbia un sottoalbero
         // dx (ossia nodi con chiavi maggiori di quella corrente). Se questo è il caso,
         // il sottoalbero (solo destro, a questo punto) di questo nodo deve diventare
         // sottoalbero diretto del nodo padre del nodo corrente, perciò è sufficiente
         // restituire il primo nodo del sottoalbero dx.
         return x.right;
   }



   @Override
   public void deleteMin() {
      root = deleteMin(root);
   }



   /**
    * Scorre l'albero fino a trovare l'elemento massimo, lo elimina e restiuisce il
    * suo sottoalbero sx. Grazie alla ricorsione questo sottoalbero si aggancia al
    * nodo padre del nodo in cui si trovava la chiave massima.
    * 
    * @param x nodo corrente
    * @return il nodo da agganciare al nodo padre del nodo eliminato
    */
   private Node deleteMax(Node x) {
      // se il nodo corrente è nullo
      if (x == null)
         // restituisce nullo
         return null;
      // se non c'è un sottoalbero dx
      if (x.right == null) // ho raggiunto il nodo con la massima chiave dell'albero
         // tuttavia anche questo nodo può avere discendenti a sinistra (ogni altra
         // chiave eventualmente presente deve stare a sinistra, essendo questo
         // l'elemento massimo), perciò la si restituisce per agganciarla al sottoalbero
         // dx del padre di questo nodo
         return x.left;
      else {
         // altrimenti c'è un sottoalbero dx quindi il nodo con la chiave massima va
         // cercato là
         x.right = deleteMax(x.right);
         // si aggiorna la dimensione di questo sottoabero
         x.n = 1 + size(x.left) + size(x.right);
         // restituisce questo nodo per chiudere la ricorsione
         return x;
      }
   }



   @Override
   public void deleteMax() {
      root = deleteMax(root);
   }



   private Node delete(Node x, K key) {
      // se il nodo corrente è nullo, esce
      if (x == null)
         return null;
      // confronta la chiave specificata con la chiave del nodo corrente
      int cmp = key.compareTo(x.key);
      if (cmp < 0) // la chiave è più piccola di quella nel nodo corrente
         // cerco nel sottoalbero sx
         x.left = delete(x.left, key);
      else
         if (cmp > 0) // la chiave è più grande di quella nel nodo corrente
            // cerco nel sottoalbero dx
            x.right = delete(x.right, key);
         else { // search hit
            // casi banali: se un sottoalbero è vuoto, basta restituire il puntatore
            // all'altro sottoalbero
            if (x.right == null)
               return x.left;
            if (x.left == null)
               return x.right;
            // ma se entrambi i sottoalberi NON sono nulli
            // salvo un riferimento al nodo corrente (quello da cancellare)
            Node d = x;
            // il nodo da restituire deve essere l'immediato successore di questo nodo
            // (successore nel senso di "nodo che contiene la chiave ceiling di quella di
            // questo nodo")
            x = min(d.right);
            // il sottoalbero dx del nodo da restituire è il sottoalbero dx del nodo
            // cancellato, privato però del nodo che ho fatto "emergere"; poiché ho fatto
            // emergere l'elemento minimo di quel sottolabero, da quello stesso sottoalbero
            // dovrò eliminare proprio l'elemento minimo.

            // RICORDARE: deleteMin(), come altri metodi di manipolazione dell'albero,
            // restituisce sempre un puntatore a un albero. Va ribadito (meglio se poi lo
            // riporti nel javadoc) che restituisce un puntatore allo stesso BST dal quale
            // però è stata eliminata la chiave più piccola. Solo attraverso le chiamate
            // ricorsive (i.e. la ricorsiva restituzione di riferimenti ad altrettanti
            // sottoalberi) avviene di fatto la cancellazione. Ma ricorda che comunque in
            // uscita hai un puntatore a un BST.
            x.right = deleteMin(d.right);
            // il sottoalbero sx del nodo da restituire è proprio il sottoalbero sx del nodo
            // cancellato
            x.left = d.left;
         }
      // aggiorna la dimensione del sottoalbero che inizia nel nodo da restituire
      x.n = 1 + size(x.left) + size(x.right);
      return x;
   }



   @Override
   public void delete(K key) {
      checkNullKey(key);
      root = delete(root, key);
   }

}
