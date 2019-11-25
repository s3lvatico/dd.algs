package org.gmnz.ddi.algs.searching;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestSequentialSearchSymbolTable {

    private SymbolTable<Integer, String> st;

    @Before
    public void beforeEachTest() {
        st = new SequentialSearchSymbolTable<>();
    }



    @Test
    public void testPut() {
        st.put(64, "Commodore");
        Assert.assertEquals("Commodore", st.get(64));
    }



    @Test(expected = IllegalArgumentException.class)
    public void testPutWithNull() {
        st.put(null, "74");
    }



    @Test
    public void testGet() {
        Assert.assertNull(st.get(42));
        st.put(64, "C");
        Assert.assertNotNull(st.get(64));
        Assert.assertTrue(st.get(64).equals("C"));
    }



    @Test(expected = IllegalArgumentException.class)
    public void testGetWithNull() {
        st.get(null);
    }



    @Test
    public void testDelete() {
        // delete deve essere idempotente. Cancello qualcosa che già non c'è, quindi
        // ri-ottengo un nullo se faccio get()
        st.delete(64);
        Assert.assertNull(st.get(64));

        // test di eliminazione di una chiave precedentemente esistente
        st.put(64, "C");
        Assert.assertNotNull(st.get(64));
        st.delete(64);
        Assert.assertNull(st.get(64));
    }



    @Test(expected = IllegalArgumentException.class)
    public void testDeleteWithNull() {
        st.delete(null);
    }



    @Test
    public void testSize() {
        Assert.assertEquals(0, st.size());
        st.put(1, "A");
        Assert.assertEquals(1, st.size());
        st.put(2, "B");
        Assert.assertEquals(2, st.size());

        st.delete(2);
        Assert.assertEquals(1, st.size());
    }



    @Test
    public void testKeysSet() {
        st.keys().forEach(t -> {
            Assert.fail();
        });

        st.put(1, "A");
        st.put(2, "B");
        st.put(3, "C");

        StringBuilder sbValues = new StringBuilder();
        st.keys().forEach(n -> {
            sbValues.append(st.get(n));
        });
        Assert.assertEquals("ABC", sbValues.toString());
    }



    @Test
    public void testContains() {
        st.put(64, "C");
        Assert.assertTrue(st.contains(64));
        Assert.assertFalse(st.contains(42));
    }



    @Test
    public void testIsEmpty() {
        Assert.assertTrue(st.isEmpty());
        st.put(64, "C");
        Assert.assertFalse(st.isEmpty());
    }
}
