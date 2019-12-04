package org.gmnz.ddi.algs.searching;

public class RedBlackBst<K extends Comparable<K>, V> extends AbstractSortedSymbolTable<K, V> {

   private static enum Color {
      RED, BLACK;
   }

   private class Node {

      K key;
      V value;
      Node left;
      Node right;
      int n;
      Color color = Color.BLACK;

      Node(K key, V value, int n, Color color) {
         this.key = key;
         this.value = value;
         this.n = n;
         this.color = color;
      }
   }

   private Node root;

   private int size(Node x) {
      return x == null ? 0 : x.n;
   }



   private Node rotateLeft(Node h) {
      Node x = h.right;
      h.right = x.left;
      x.left = h;
      x.color = h.color;
      h.color = Color.RED;
      x.n = h.n;
      h.n = 1 + size(x.left) + size(x.right);
      return x;
   }



   private Node rotateRight(Node h) {
      Node x = h.left;
      h.left = x.right;
      x.right = h;
      x.color = h.color;
      h.color = Color.RED;
      x.n = h.n;
      h.n = 1 + size(h.left) + size(h.right);
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



   private boolean isRed(Node x) {
      return x != null && x.color == Color.RED;
   }



   private Node flipColors(Node x) {
      x.color = Color.RED;
      x.left.color = Color.BLACK;
      x.right.color = Color.BLACK;
      return x;
   }



   private Node put(Node x, K key, V value) {
      if (x == null)
         return new Node(key, value, 1, Color.RED);
      int cmp = key.compareTo(x.key);
      if (cmp < 0)
         x.left = put(x.left, key, value);
      else
         if (cmp > 0)
            x.right = put(x.right, key, value);
         else
            x.value = value;
      if (isRed(x.right) && !isRed(x.left))
         x = rotateLeft(x);
      if (isRed(x.left) && isRed(x.left.left))
         x = rotateRight(x);
      if (isRed(x.left) && isRed(x.right))
         x = flipColors(x);
      x.n = 1 + size(x.left) + size(x.right);
      return x;
   }



   @Override
   public void put(K key, V value) {
      checkNullKey(key);
      root = put(root, key, value);
      root.color = Color.BLACK;
   }



   private Node get(Node x, K key) {
      if (x == null)
         return null;
      int cmp = key.compareTo(x.key);
      if (cmp < 0)
         return get(x.left, key);
      else
         if (cmp > 0)
            return get(x.right, key);
         else
            return x;
   }



   @Override
   public V get(K key) {
      checkNullKey(key);
      Node x = get(root, key);
      return x != null ? x.value : null;
   }



   @Override
   public int size() {
      return size(root);
   }

}