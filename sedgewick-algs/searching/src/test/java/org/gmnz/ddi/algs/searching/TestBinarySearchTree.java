package org.gmnz.ddi.algs.searching;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestBinarySearchTree {

   private BinarySearchTree<Integer, String> bst;

   @Before
   public void beforeEachTest() {
      bst = new BinarySearchTree<>();
   }



   @Test
   public void testSize() {
      Assert.assertEquals(0, bst.size());
      bst.put(64, "c");
      Assert.assertEquals(1, bst.size());
      bst.put(16, "vic20");
      bst.put(128, "c128");
      Assert.assertEquals(3, bst.size());
   }



   @Test(expected = IllegalArgumentException.class)
   public void testGetWithNullKey() {
      bst.get(null);
   }



   @Test
   public void testGetAndPut() {
      Assert.assertNull(bst.get(64));
      bst.put(64, "c");
      bst.put(16, "vic20");
      bst.put(128, "c128");
      bst.put(32, "trentadue");
      Assert.assertEquals("vic20", bst.get(16));
      Assert.assertEquals("c128", bst.get(128));
      Assert.assertEquals("trentadue", bst.get(32));

      bst.put(64, "C=64 my great love");
      Assert.assertEquals("C=64 my great love", bst.get(64));
   }
}