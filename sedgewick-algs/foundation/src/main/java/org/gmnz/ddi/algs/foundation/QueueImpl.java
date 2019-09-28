package org.gmnz.ddi.algs.foundation;

class QueueImpl<K> implements Queue<K> {

    private Node<K> head;
    private Node<K> tail;

    private int size;

    @Override
    public void insert(K k) {
        if (head == null) {
            Node<K> n = new Node<>(k);
            n.next = null;
            head = n;
            tail = n;
        } else {
            Node<K> n = new Node<>(k);
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
            return head.value;
    }



    @Override
    public K poll() {
        if (head == null)
            return null;
        Node<K> n = head;
        head = head.next;
        K key = n.value;
        n = null;
        size--;
        return key;
    }



    public int size() {
        return size;
    }



    public String toString() {
        StringBuilder sb = new StringBuilder("[  ");
        Node<K> n = head;
        while (n != null) {
            sb.append(n.value).append("  ");
            n = n.next;
        }
        sb.append("]");
        return sb.toString();
    }
}