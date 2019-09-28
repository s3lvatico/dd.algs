package org.gmnz.ddi.algs.foundation;


import org.gmnz.ddi.algs.util.Point2d;
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



   @Test
   public void complexStack() {
      Point2d p = new Point2d();
      p.setA(2);
      p.setB(-1);

      Stack<Point2d> pointStack = Stacks.createComparableStack();
      pointStack.push(p);
      // Point2d [a=2.0, b=-1.0]
      Assert.assertEquals("Point2d [a=2.0, b=-1.0]", p.toString());
      Assert.assertEquals(1, pointStack.size());
   }

}