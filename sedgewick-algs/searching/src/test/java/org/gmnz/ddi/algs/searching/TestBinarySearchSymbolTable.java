package org.gmnz.ddi.algs.searching;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestBinarySearchSymbolTable {

   private SortedSymbolTable<Integer, String> st;
   private static final int DEFAULT_TABLE_SIZE = 5;

   @Before
   public void before() {
      st = new BinarySearchSymbolTable<>(DEFAULT_TABLE_SIZE);
   }



   private void fillTableWithSampleData() {
      // per fissare le idee uso come chiavi i primi 5 multipli di 3, e come valori le
      // prime 5 lettere dell'alfabeto
      String sampleData = "ABCDE";
      for (int i = 0; i < DEFAULT_TABLE_SIZE; i++)
         st.put(3 * (i + 1), sampleData.substring(i, i + 1));
   }



   @Test
   public void testSize() {
      Assert.assertEquals(0, st.size());
      st.put(1, "A");
      Assert.assertEquals(1, st.size());
      st.put(2, "B");
      Assert.assertEquals(2, st.size());
   }



   @Test
   public void testRank() {

      fillTableWithSampleData();

      // 3 è esattamente la prima chiave nella tabella ==> non ci sono chiavi
      // strettamente minori di 3 ==> rango 0
      Assert.assertEquals(0, st.rank(3));

      // la chiave 7 deve avere rango 2, essendoci prima di lei la sola chiave 3
      Assert.assertEquals(2, st.rank(7));

      Assert.assertEquals(4, st.rank(13));
   }



   @Test(expected = IllegalArgumentException.class)
   public void testRankWithNullKey() {
      st.rank(null);
   }



   @Test
   public void testGet() {
      String valueForEmptyTable = st.get(42);
      Assert.assertNull(valueForEmptyTable);
      fillTableWithSampleData();

      // search hit
      String hit = st.get(9);
      Assert.assertNotNull(hit);
      Assert.assertEquals("C", hit);

      // search miss
      Assert.assertNull(st.get(7));
   }



   @Test(expected = IllegalArgumentException.class)
   public void testGetWithNullKey() {
      st.get(null);
   }



   @Test
   public void testPut() {
      st.put(1, "A");
      st.put(5, "Z");
      st.put(3, "Q");

      Assert.assertNotNull(st.get(1));
      Assert.assertNotNull(st.get(3));
      Assert.assertNotNull(st.get(5));
   }



   @Test(expected = IllegalArgumentException.class)
   public void testPutWithNullKey() {
      st.put(null, "dummy");
   }



   @Test(expected = UnsupportedOperationException.class)
   public void testPutWithFullTable() {
      fillTableWithSampleData();

      st.put(3, "updated value");
      // questo assicura in modo ancora più stringente che si è fatto un aggiornamento
      // e non un'aggiunta alla ST
      Assert.assertEquals(DEFAULT_TABLE_SIZE, st.size());

      st.put(4, "exceeding element");
   }

}