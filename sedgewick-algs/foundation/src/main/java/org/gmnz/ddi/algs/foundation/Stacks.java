package org.gmnz.ddi.algs.foundation;

/**
 * Stacks
 */
public class Stacks {

   public static Stack<Integer> createIntegerStack() {
      return new StackImpl<Integer>();
   }
}