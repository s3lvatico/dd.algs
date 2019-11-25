package org.gmnz.ddi.algs.searching;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractSortedSymbolTable<K, V> {

   /**
    * radice del BST
    */
   private Node root;

   private class Node {

      private K key;
      private V value;
      private Node left;
      private Node right;
      /**
       * numero di nodi nei sottoalberi che iniziano a questo nodo
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
      return size(root);
   }



   @Override
   public V get(K key) {
      checkNullKey(key);
      return get(root, key);
   }



   private V get(Node x, K key) {
      if (x == null)
         return null;
      int cmp = key.compareTo(x.key);
      if (cmp < 0)
         return get(x.left, key);
      else
         if (cmp > 0)
            return get(x.right, key);
         else
            return x.value;
   }



   @Override
   public void put(K key, V value) {
      checkNullKey(key);
      root = put(root, key, value);
   }



   private Node put(Node x, K key, V value) {
      if (x == null)
         return new Node(key, value, 1);
      int cmp = key.compareTo(x.key);
      if (cmp < 0)
         x.left = put(x.left, key, value);
      else
         if (cmp > 0)
            x.right = put(x.right, key, value);
         else
            x.value = value;
      x.n = 1 + size(x.left) + size(x.right);
      return x;
   }



   @Override
   public K min() {
      // TODO Auto-generated method stub
      return null;
   }



   @Override
   public K max() {
      // TODO Auto-generated method stub
      return null;
   }



   @Override
   public K floor(K key) {
      // TODO Auto-generated method stub
      return null;
   }



   @Override
   public K ceiling(K key) {
      // TODO Auto-generated method stub
      return null;
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

}