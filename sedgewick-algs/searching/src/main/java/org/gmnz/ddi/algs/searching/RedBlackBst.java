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



   @Override
   public void put(K key, V value) {
      // TODO Auto-generated method stub

   }



   @Override
   public V get(K key) {
      // TODO Auto-generated method stub
      return null;
   }



   @Override
   public int size() {
      return size(root);
   }

}