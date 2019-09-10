package org.gmnz.ddi.algs.sort2;


import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


public class TestQSortG {


    @Test
    public void test9() {
        QSortG<Integer> qs = new QSortG<>(new Integer[] { 9, 5, 7, 6, 8, 3, 4, 1, 2 });
        System.out.println(qs.arrayAsString());
        Assert.assertFalse(qs.isSorted());
        qs.sort();
        System.out.println(qs.arrayAsString());
        Assert.assertTrue(qs.isSorted());
    }



    @Test
    public void test100() {
        Random rnd = new Random();
        Integer[] v = new Integer[100];
        for (int i = 0; i < 100; i++) {
            v[i] = rnd.nextInt(500);
        }
        QSortG<Integer> qs = new QSortG<>(v);
        System.out.println(qs.arrayAsString());
        Assert.assertFalse(qs.isSorted());
        qs.sort();
        System.out.println(qs.arrayAsString());
        Assert.assertTrue(qs.isSorted());
    }
}