package org.gmnz.ddi.algs.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * InsertionSortTest
 */
public class InsertionSortTest {

   @Test
   public void testSelectionSort() {
      int[] v = ArrayUtils.randomIntArray(10, 0, 20);
      while (!ArrayUtils.isSorted(v)) {
         v = ArrayUtils.randomIntArray(10, 0, 20);
      }
      new InsertionSort().sort(v);
      Assert.assertTrue(ArrayUtils.isSorted(v));
   }

   @Test
   public void testPathologicLengths() {
      int[] vNull = null;
      new InsertionSort().sort(vNull);
      Assert.assertTrue(ArrayUtils.isSorted(vNull));

      int[] v = ArrayUtils.randomIntArray(0, 0, 20);
      while (!ArrayUtils.isSorted(v)) {
         v = ArrayUtils.randomIntArray(0, 0, 20);
      }
      new InsertionSort().sort(v);
      Assert.assertTrue(ArrayUtils.isSorted(v));

      v = ArrayUtils.randomIntArray(1, 0, 20);
      while (!ArrayUtils.isSorted(v)) {
         v = ArrayUtils.randomIntArray(1, 0, 20);
      }
      new InsertionSort().sort(v);
      Assert.assertTrue(ArrayUtils.isSorted(v));

   }
}