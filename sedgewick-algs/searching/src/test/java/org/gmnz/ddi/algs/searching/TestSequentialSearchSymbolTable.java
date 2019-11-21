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
}