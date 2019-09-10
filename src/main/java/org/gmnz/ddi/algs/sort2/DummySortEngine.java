package org.gmnz.ddi.algs.sort2;


/**
 * DummySortEngine
 */
public class DummySortEngine<K extends Comparable<K>> extends AbstractSortEngine<K> {

    @SuppressWarnings("unchecked")
    DummySortEngine(int size) {
        v = (K[]) new Comparable[size];
    }



    public static void main(String[] args) {
        AbstractSortEngine<Integer> ase = new DummySortEngine<>(5);
        System.out.println(ase.arrayAsString());

        ase = new DummySortEngine<>(0);
        System.out.println(ase.arrayAsString());
    }



    @Override
    public void sort() {
        System.err.println("I'm a dud");
    }

}