package org.gmnz.ddi.algs.searching;

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



   @Override
   public int rank(K key) {
      // TODO Auto-generated method stub
      return 0;
   }



   @Override
   public K select(int r) {
      // TODO Auto-generated method stub
      return null;
   }



   @Override
   public Iterable<K> keys(K lo, K hi) {
      // TODO Auto-generated method stub
      return null;
   }

   // TODO delete(K) va implementata adeguatamente

}