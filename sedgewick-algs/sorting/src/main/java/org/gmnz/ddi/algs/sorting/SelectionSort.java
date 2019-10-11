package org.gmnz.ddi.algs.sorting;

/**
 * SelectionSort
 */
public class SelectionSort extends BaseSortEngine {

   /**
    * ad ogni passaggio prende l'elemento minimo e lo posiziona dopo i minimi
    * finora trovati
    */
   public void sort(int[] v) {
      if ( v == null || v.length < 2) {
         return;
      }
      int min;
      for (int i = 0; i < v.length - 1; i++) {
         min = i;
         for (int j = i + 1; j < v.length; j++) {
            if (v[j] < v[min]) {
               min = j;               
            }
         }
         swap(v, i, min);
      }
   }

}