package org.gmnz.ddi.algs.searching;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestBinarySearchTree {

   private BinarySearchTree<Integer, String> bst;
   private static final String[] ARR_SEARCH_EXAMPLE = { "S", "E", "A", "R", "C", "H", "E", "X", "A", "M", "P", "L", "E" };

   private BinarySearchTree<String, Integer> searchExampleBst;

   @Before
   public void beforeEachTest() {
      bst = new BinarySearchTree<>();
      searchExampleBst = new BinarySearchTree<>();
   }



   private void fillWithSearchExample() {
      int value = 0;
      for (String s : ARR_SEARCH_EXAMPLE) {
         searchExampleBst.put(s, value++);
      }

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



   @Test
   public void testFloor() {
      fillWithSearchExample();
      Assert.assertEquals("M", searchExampleBst.floor("O"));
      Assert.assertEquals("X", searchExampleBst.floor("X"));
      Assert.assertEquals("A", searchExampleBst.floor("A"));
      Assert.assertEquals("A", searchExampleBst.floor("B"));
      Assert.assertEquals("C", searchExampleBst.floor("D"));
      Assert.assertNull(searchExampleBst.floor("@"));
   }



   @Test(expected = IllegalArgumentException.class)
   public void testFloorWithNullKey() {
      fillWithSearchExample();
      searchExampleBst.floor(null);
   }



   @Test(expected = IllegalArgumentException.class)
   public void testCeilingWithNullKey() {
      fillWithSearchExample();
      searchExampleBst.ceiling(null);
   }



   @Test
   public void testCeiling() {
      fillWithSearchExample();
      Assert.assertNull(searchExampleBst.ceiling("Y"));
      Assert.assertEquals("A", searchExampleBst.ceiling("A"));
      Assert.assertEquals("C", searchExampleBst.ceiling("B"));
      Assert.assertEquals("E", searchExampleBst.ceiling("D"));
      Assert.assertEquals("E", searchExampleBst.ceiling("E"));
      Assert.assertEquals("H", searchExampleBst.ceiling("F"));
      Assert.assertEquals("H", searchExampleBst.ceiling("G"));
      Assert.assertEquals("L", searchExampleBst.ceiling("I"));
      Assert.assertEquals("L", searchExampleBst.ceiling("J"));
      Assert.assertEquals("L", searchExampleBst.ceiling("K"));
      Assert.assertEquals("L", searchExampleBst.ceiling("L"));
      Assert.assertEquals("M", searchExampleBst.ceiling("M"));
      Assert.assertEquals("P", searchExampleBst.ceiling("N"));
      Assert.assertEquals("P", searchExampleBst.ceiling("O"));
      Assert.assertEquals("P", searchExampleBst.ceiling("P"));
      Assert.assertEquals("R", searchExampleBst.ceiling("Q"));
      Assert.assertEquals("R", searchExampleBst.ceiling("R"));
      Assert.assertEquals("S", searchExampleBst.ceiling("S"));
      Assert.assertEquals("X", searchExampleBst.ceiling("T"));
      Assert.assertEquals("X", searchExampleBst.ceiling("U"));
      Assert.assertEquals("X", searchExampleBst.ceiling("V"));
      Assert.assertEquals("X", searchExampleBst.ceiling("W"));
      Assert.assertEquals("X", searchExampleBst.ceiling("X"));
   }



   @Test
   public void testMin() {
      Assert.assertNull(bst.min());
      fillWithSearchExample();
      Assert.assertEquals("A", searchExampleBst.min());
   }



   @Test
   public void testMax() {
      Assert.assertNull(bst.max());
      fillWithSearchExample();
      Assert.assertEquals("X", searchExampleBst.max());
   }



   @Test
   public void select() {
      Assert.assertNull(searchExampleBst.select(2));
      fillWithSearchExample();
      Assert.assertEquals("A", searchExampleBst.select(0));
      Assert.assertEquals("C", searchExampleBst.select(1));
      Assert.assertEquals("E", searchExampleBst.select(2));
   }



   @Test(expected = IllegalArgumentException.class)
   public void selectWithWrongRank() {
      bst.select(-1);
   }



   @Test
   public void testDeleteMin() {
      bst.deleteMin();
      fillWithSearchExample();
      searchExampleBst.deleteMin(); // deve eliminare la "A"
      Assert.assertNull(searchExampleBst.get("A"));
      Assert.assertEquals(0, searchExampleBst.rank("C"));

      searchExampleBst.deleteMin(); // deve eliminare la "C"
      Assert.assertNull(searchExampleBst.get("C"));
      Assert.assertEquals(0, searchExampleBst.rank("E"));
      Assert.assertEquals("E", searchExampleBst.min());
      
      // ora se elimino la "E" , la "R" si aggancia sotto la root, e il nuovo minimo
      // deve essere la "H"
      searchExampleBst.deleteMin();
      Assert.assertEquals("H", searchExampleBst.min());
      // e la "R" deve avere 4 chiavi prima di lei
      Assert.assertEquals(4, searchExampleBst.rank("R"));

   }
}