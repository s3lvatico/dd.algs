package org.gmnz.ddi.algs.tree;

class BinarySearchTree<K extends Comparable<K>, V> implements Tree<K, V> {

   private class Node {

      private K key;
      private V value;
      private Node left;
      private Node right;
      private int n;

      Node(K key, V value, int size) {
         this.key = key;
         this.value = value;
         n = size;
      }
   }

   private Node root;

   @Override
   public V get(K key) {
      if (root == null)
         return null;
      else
         return get(key, root);
   }



   private V get(K key, Node x) {
      if (x == null)
         return null;
      if (x.key.compareTo(key) < 0)
         return get(key, x.left);
      if (x.key.compareTo(key) > 0)
         return get(key, x.right);
      return x.value;

   }



   @Override
   public void put(K key, V value) {
      if (root == null) {
         root = new Node(key, value, 1);
      }
   }



   @Override
   public int size() {
      if (root == null)
         return 0;
      else
         return root.n;
   }

}