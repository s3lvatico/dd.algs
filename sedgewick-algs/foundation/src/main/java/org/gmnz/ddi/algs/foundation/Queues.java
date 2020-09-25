package org.gmnz.ddi.algs.foundation;

/**
 * Classe factory per le code
 */
public class Queues {

    private Queues() {}



    /**
     * Crea una coda vuota di elementi interi
     */
    public static Queue<Integer> createIntegerQueue() {
        return new QueueImpl<>();
    }



    public static <K extends Comparable<K>> Queue<K> createComparableQueue() {
        return new QueueImpl<>();
    }
}