package org.gmnz.ddalg.pq;

import org.junit.Assert;
import org.junit.Test;

/**
 * UnorderedArrayMaxPQTest
 */
public class UnorderedArrayMaxPQTest {

    @Test public void dummy() {
        Assert.assertTrue(true);
    }
    

    @Test public void testInsert() {
        UnorderedArrayMaxPQ<String> mpq = new UnorderedArrayMaxPQ<String>(10);
        mpq.insert("lorem");
        mpq.insert("sit");
        mpq.insert("ipsum");
        mpq.insert("dolor");
        mpq.insert("anem");
        
        int expectedSize = 5;
        Assert.assertFalse(mpq.isEmpty());
        Assert.assertEquals(expectedSize, mpq.size());
        Assert.assertEquals("sit", mpq.delMax());
        Assert.assertEquals(--expectedSize, mpq.size());

    }
}