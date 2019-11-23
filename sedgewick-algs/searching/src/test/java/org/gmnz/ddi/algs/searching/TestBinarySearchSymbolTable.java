package org.gmnz.ddi.algs.searching;


import static org.junit.Assert.assertEquals;

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



   @Test
   public void testMin() {
      fillTableWithSampleData();
      Assert.assertEquals(Integer.valueOf(3), st.min());
   }



   @Test
   public void testMax() {
      fillTableWithSampleData();
      Assert.assertEquals(Integer.valueOf(15), st.max());
   }



   @Test
   public void testFloor() {
      Assert.assertNull(st.floor(64));
      fillTableWithSampleData();
      Assert.assertNull(st.floor(2));
      Assert.assertEquals(Integer.valueOf(3), st.floor(3));
      Assert.assertEquals(Integer.valueOf(15), st.floor(64));
   }



   @Test(expected = IllegalArgumentException.class)
   public void testFloorWithNull() {
      st.floor(null);
   }



   @Test
   public void testCeiling() {
      Assert.assertNull(st.ceiling(64));
      fillTableWithSampleData();
      Assert.assertNull(st.ceiling(64));
      Assert.assertEquals(Integer.valueOf(12), st.ceiling(10));
   }



   @Test(expected = IllegalArgumentException.class)
   public void testCeilingWithNullKey() {
      st.ceiling(null);
   }



   @Test(expected = IllegalArgumentException.class)
   public void testSelectNegativeRank() {
      st.select(-2);
   }



   @Test(expected = IllegalArgumentException.class)
   public void testSelectExcessiveRank() {
      st.select(DEFAULT_TABLE_SIZE);
   }



   @Test
   public void testSelect() {
      fillTableWithSampleData();
      // 12 è la chiave di rango 3 (cioè ha 3 chiavi dietro di sé, infatti sono 3, 6 e
      // 9)
      Assert.assertEquals(Integer.valueOf(12), st.select(3));

      // deve valere l'identità select(rank(k)) = k per ogni k della ST
      Assert.assertEquals(Integer.valueOf(9), st.select(st.rank(9)));

      // deve valere anche l'identità inversa: rank(select(r)) = r per ogni r valido
      Assert.assertEquals(Integer.valueOf(3), Integer.valueOf(st.rank(st.select(3))));
   }



   @Test
   public void testKeysSet() {
      st.keys().forEach(t -> {
         Assert.fail();
      });

      fillTableWithSampleData();

      StringBuilder sbValues = new StringBuilder();
      st.keys().forEach(n -> {
         sbValues.append(st.get(n));
      });
      Assert.assertEquals("ABCDE", sbValues.toString());
   }



   @Test
   public void testSizeRanged() {
      fillTableWithSampleData();
      // indici in ordine sbagliato, size == 0
      Assert.assertEquals(0, st.size(6, 3));

      Assert.assertEquals(3, st.size(6, 12));
      Assert.assertEquals(3, st.size(5, 13));
   }



   @Test(expected = IllegalArgumentException.class)
   public void testSizeRangedWithLoNull() {
      st.size(null, Integer.valueOf(2));
   }



   @Test(expected = IllegalArgumentException.class)
   public void testSizeRangedWithHiNull() {
      st.size(Integer.valueOf(2), null);
   }



   @Test
   public void testKeysRangedWithNulls() {
      try {
         st.keys(null, Integer.valueOf(1));
         Assert.fail("should've thrown exception");
      } catch (IllegalArgumentException e) {
         // ok
      }
      try {
         st.keys(Integer.valueOf(1), null);
         Assert.fail("should've thrown exception");
      } catch (IllegalArgumentException e) {
         // ok
      }
   }



   @Test
   public void testKeysRanged() {
      st.keys(3, 3).forEach(key -> {
         Assert.fail("expecting an empty set");
      });
      fillTableWithSampleData();
      StringBuilder sb = new StringBuilder();
      st.keys(6, 12).forEach(key -> {
         sb.append(key).append(",");
      });
      assertEquals("6,9,12,", sb.toString());
   }
}