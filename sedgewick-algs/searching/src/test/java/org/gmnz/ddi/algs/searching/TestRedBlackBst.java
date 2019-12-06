package org.gmnz.ddi.algs.searching;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestRedBlackBst {

    private RedBlackBst<String, Integer> bst;
    private static final String SAMPLE_DATA = "SEARCHEXAMPLE";

    @Before
    public void beforeTest() {
        bst = new RedBlackBst<>();
    }



    private void fillWithTestData() {
        for (int i = 0; i < SAMPLE_DATA.length(); i++) {
            bst.put(String.valueOf(SAMPLE_DATA.charAt(i)), i);
        }
    }



    @Test
    public void testGet() {
        fillWithTestData();
        Assert.assertNull(bst.get("Q"));
    }

    @Test
    public void testEasyQuestion() {
        String EASY_QUESTION = "EASYQUTION";
        for (int i = 0; i < EASY_QUESTION.length(); i++) {
            String s = String.valueOf(EASY_QUESTION.charAt(i));
            bst.put(s, i);
        }
        Assert.assertNotNull(bst.get("E"));
    }
}