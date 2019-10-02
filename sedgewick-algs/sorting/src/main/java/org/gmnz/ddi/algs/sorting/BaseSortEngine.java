package org.gmnz.ddi.algs.sorting;


/**
 * BaseSortEngine
 */
class BaseSortEngine {

    protected void swap(Comparable<?>[] arr, int i, int j) {
        Comparable<?> temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    protected void swap(byte[] arr, int i, int j) {
        byte temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    protected void swap(short[] arr, int i, int j) {
        short temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    protected void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    protected void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    protected void swap(float[] arr, int i, int j) {
        float temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    protected void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    protected void swap(boolean[] arr, int i, int j) {
        boolean temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    protected <K extends Comparable<K>> boolean less(K c1, K c2) {
        return c1.compareTo(c2) < 0;
    }

}