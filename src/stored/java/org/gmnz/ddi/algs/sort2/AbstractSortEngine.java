package org.gmnz.ddi.algs.sort2;


abstract class AbstractSortEngine<K extends Comparable<K>> {

    public abstract void sort();

    protected K[] v;

    protected boolean less(int i, int j) {
        return v[i].compareTo(v[j]) < 0;
    }

    protected boolean less(K x, K y) {
        return x.compareTo(y) < 0;
    }


    protected void swap(int i, int j) {
        K tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;
    }



    protected String arrayAsString() {
        StringBuilder sb = new StringBuilder("[ ");
        if (v.length == 0) {
            sb.append("]");
        }
        else {

            int i = 0;
            while (i < v.length - 1) {
                sb.append(v[i] + ",  ");
                i++;
            }
            sb.append(v[i] + " ]");
        }
        return sb.toString();
    }



    protected boolean isSorted() {
        if (v.length <= 1)
            return true;
        for (int i = 1; i < v.length; i++) {
            if (less(i, i - 1))
                return false;
        }
        return true;
    }



    public K[] getArray() {
        return v;
    }

}