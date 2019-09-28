package org.gmnz.ddi.algs.foundation;

/**
 * StackImpl
 */
class StackImpl<K> implements Stack<K> {

   private Node<K> top;
   int size = 0;

   @Override
   public void push(K k) {
      Node<K> n = new Node<>();
      n.value = k;
      n.next = top;
      top = n;
      size++;
   }

   @Override
   public K pop() {
      if (top == null) {
         return null;
      }
      Node<K> n = top;
      top = top.next;
      size--;
      return n.value;
   }

   @Override
   public int size() {
      return size;
   }

}