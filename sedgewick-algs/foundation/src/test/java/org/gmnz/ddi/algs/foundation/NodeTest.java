package org.gmnz.ddi.algs.foundation;


import org.junit.Assert;
import org.junit.Test;


public class NodeTest {

    @Test
    public void nodeCreation() {
        String stringValue = "ciao";
        Node<String> stringNode = new Node<>();
        stringNode.value = stringValue;
        stringNode.next = new Node<>();

        Assert.assertNotNull(stringNode.value);
        Assert.assertNotNull(stringNode.next);

    }



    @Test
    public void constructors() {
        Node<Integer> n0 = new Node<>();
        Assert.assertNull(n0.value);
        Assert.assertNull(n0.next);

        Node<Integer> n1 = new Node<>(64);
        Assert.assertEquals(64, n1.value.intValue());
        Assert.assertNull(n1.next);

        Node<Integer> n2 = new Node<>(42, n1);
        Assert.assertEquals(42, n2.value.intValue());
        Assert.assertNotNull(n2.next);
    }
}