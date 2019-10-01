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

}