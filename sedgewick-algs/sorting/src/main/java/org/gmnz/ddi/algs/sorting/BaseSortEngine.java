package org.gmnz.ddi.algs.sorting;

/**
 * BaseSortEngine. Classe base contenente il minimo di metodi di utilità e
 * comuni ai vari algoritmi di ordinamento.
 */
class BaseSortEngine {

    /**
     * Scambia di posto due elementi date le posizioni
     * 
     * @param arr array su cui operare
     * @param i   indice del primo elemento
     * @param j   indice del secondo elemento
     */
    protected void swap(Comparable<?>[] arr, int i, int j) {
        Comparable<?> temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * come {@link #swap(Comparable[], int, int)} ma con array di {@code byte}
     */
    protected void swap(byte[] arr, int i, int j) {
        byte temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * come {@link #swap(Comparable[], int, int)} ma con array di {@code short}
     */
    protected void swap(short[] arr, int i, int j) {
        short temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * come {@link #swap(Comparable[], int, int)} ma con array di {@code int}
     */
    protected void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * come {@link #swap(Comparable[], int, int)} ma con array di {@code long}
     */
    protected void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * come {@link #swap(Comparable[], int, int)} ma con array di {@code float}
     */
    protected void swap(float[] arr, int i, int j) {
        float temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * come {@link #swap(Comparable[], int, int)} ma con array di {@code double}
     */

    protected void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * come {@link #swap(Comparable[], int, int)} ma con array di {@code boolean}
     */
    protected void swap(boolean[] arr, int i, int j) {
        boolean temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * verifica se due elementi {@code Comparable} sono in sequenza, i.e. il primo
     * strettamente inferiore del secondo.
     * 
     * @param <K> il tipo che estenda {@link Comparable}
     * @param c1  primo elemento
     * @param c2  secondo elemento
     * @return {@code true} se il primo elemento è strettamente inferiore al secondo
     */
    protected <K extends Comparable<K>> boolean less(K c1, K c2) {
        return c1.compareTo(c2) < 0;
    }

}