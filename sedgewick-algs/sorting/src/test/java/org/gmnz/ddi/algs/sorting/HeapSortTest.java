package org.gmnz.ddi.algs.sorting;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;


public class HeapSortTest {

   @Test
   public void testHeapSort() {
      Random rnd = new Random();
      final int ARRAY_SIZE = rnd.nextInt(Byte.MAX_VALUE);
      final int UPPER_BOUND = rnd.nextInt(Short.MAX_VALUE);
      Integer[] v = ArrayUtils.randomIntegerArray(ARRAY_SIZE, 0, UPPER_BOUND);
      while (ArrayUtils.isSorted(v)) {
         v = ArrayUtils.randomIntegerArray(ARRAY_SIZE, 0, UPPER_BOUND);
      }
      Assert.assertFalse(ArrayUtils.isSorted(v));
      HeapSort<Integer> heapSort = new HeapSort<>(v);
      Comparable<Integer>[] arr = heapSort.sort();
      // questo è delirante, ma è l' unico modo che ho trovato per trasformare un
      // Comparable<Integer> in un Integer
      Integer[] sortedArray = Arrays.asList(arr).stream().map(c -> {
         return Integer.parseInt(c.toString());
      }).collect(Collectors.toList()).toArray(new Integer[] {});
      Assert.assertTrue(ArrayUtils.isSorted(sortedArray));
   }

}
