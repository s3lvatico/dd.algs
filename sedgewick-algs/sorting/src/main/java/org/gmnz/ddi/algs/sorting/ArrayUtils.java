package org.gmnz.ddi.algs.sorting;


/**
 * ArrayUtils
 */
public class ArrayUtils {

    private ArrayUtils() {
    }



    public static String toString(byte[] v) {
        StringBuilder sb = new StringBuilder("[");
        for (byte b : v) {
            sb.append(String.format("%6d", b));
        }
        sb.append(" ]");
        return sb.toString();
    }



    public static String toString(int[] v) {
        double dblHighestMagnitude = 0;
        for (int x : v) {
            double dblMag = Math.log10(x);
            if (dblMag > dblHighestMagnitude)
                dblHighestMagnitude = dblMag;
        }
        dblHighestMagnitude = Math.ceil(dblHighestMagnitude);
        int spacing = Double.valueOf(Math.round(dblHighestMagnitude / 1.618)).intValue();
        int magnitude = Double.valueOf(dblHighestMagnitude).intValue();

        int formatWidth = magnitude + spacing;
        String formatString = "%" + formatWidth + "d";

        StringBuilder sb = new StringBuilder("[");
        for (int x : v) {
            sb.append(String.format(formatString, x));
        }
        sb.append(" ]");
        return sb.toString();
    }
}