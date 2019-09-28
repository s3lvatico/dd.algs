package org.gmnz.ddi.algs.foundation;


import org.junit.Assert;
import org.junit.Test;


/**
 * TestStacks
 */
public class TestStacks {

   @Test
   public void intStack() {
      Stack<Integer> si = Stacks.createIntegerStack();
      Assert.assertEquals(0, si.size());
      si.push(42);
      Assert.assertEquals(1, si.size());
      si.push(64);
      Assert.assertEquals(2, si.size());

      Assert.assertEquals(64, si.pop().intValue());
      Assert.assertEquals(1, si.size());

      Assert.assertEquals(42, si.pop().intValue());
      Assert.assertEquals(0, si.size());

      Assert.assertNull(si.pop());

   }

}