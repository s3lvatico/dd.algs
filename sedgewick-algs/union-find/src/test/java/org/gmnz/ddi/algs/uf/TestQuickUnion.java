package org.gmnz.ddi.algs.uf;


import org.junit.Assert;
import org.junit.Test;


public class TestQuickUnion {

    @Test
    public void operateQuickUnion() {
        UnionFind uf = new QuickUnionUF(5);
        Assert.assertEquals(5, uf.nComponents);
        Assert.assertFalse(uf.connected(0, 1));
        Assert.assertFalse(uf.connected(2, 3));
        Assert.assertFalse(uf.connected(4, 0));
        uf.union(3, 4);
        Assert.assertEquals(4, uf.nComponents);
        Assert.assertTrue(uf.connected(3, 4));
    }
}