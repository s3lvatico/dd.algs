package org.gmnz.ddi.algs.graph3;


class BasicQueue<K> implements Queue<K> {

    private class Node {
        K key;
        Node next;

        Node(K key) {
            this.key = key;
        }
    }

    private Node head;
    private Node tail;

    private int size;

    @Override
    public void insert(K k) {
        if (head == null) {
            Node n = new Node(k);
            n.next = null;
            head = n;
            tail = n;
        }
        else {
            Node n = new Node(k);
            n.next = null;
            tail.next = n;
            tail = n;
        }
        size++;
    }



    @Override
    public K peek() {
        if (head == null)
            return null;
        else
            return head.key;
    }



    @Override
    public K poll() {
        if (head == null)
            return null;
        Node n = head;
        head = head.next;
        K key = n.key;
        n = null;
        size--;
        return key;
    }



    public int size() {
        return size;
    }



    public String toString() {
        StringBuilder sb = new StringBuilder("[  ");
        Node n = head;
        while (n != null) {
            sb.append(n.key).append("  ");
            n = n.next;
        }
        sb.append("]");
        return sb.toString();
    }
}