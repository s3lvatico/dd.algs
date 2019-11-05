package org.gmnz.ddi.algs.sorting;

/**
 * InsertionSort
 */
public class InsertionSort extends BaseSortEngine {

   public void sort(int[] v) {
      if (v == null || v.length == 1)
         return;
      for (int i = 1; i < v.length; i++) {
         for (int j = i; j > 0; j--) {
            if (less(v[j], v[j - 1])) {
               swap(v, j, j - 1);
            }
         }
      }
   }

}