package org.gmnz.ddi.algs.foundation;

/**
 * Stacks
 */
public class Stacks {

   private Stacks() {}

   public static Stack<Integer> createIntegerStack() {
      return new StackImpl<>();
   }

   public static <K extends Comparable<K>> Stack<K> createComparableStack() {
      return new StackImpl<>();
   }
}