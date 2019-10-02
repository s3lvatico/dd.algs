package org.gmnz.ddi.algs.sorting;


/**
 * ArrayUtils
 */
class ArrayUtils {

    private ArrayUtils() {}

    static String toString(byte[] v) {
        StringBuilder sb = new StringBuilder("[");
        for (byte b : v) {
            sb.append(String.format("%6d", b));
        }
        sb.append(" ]");
        return sb.toString();
    }

}