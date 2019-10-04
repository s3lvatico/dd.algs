package org.gmnz.ddi.algs.sorting;


import java.util.Random;


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



    public static boolean isSorted(int[] v) {
        if (v == null || v.length < 2)
            return true;
        int i = 1;
        while (i < v.length) {
            if (v[i] < v[i - 1])
                return false;
            i++;
        }
        return true;
    }



    public static int[] randomIntArray(int length, int lowerBound, int upperBound) {
        if (length < 0)
            return null;
        if (length == 0)
            return new int[] {};
        int[] v = new int[length];
        Random r = new Random();
        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        for (int i = 0; i < v.length; i++) {
            v[i] = lowerBound + r.nextInt(upperBound - lowerBound);
        }
        return v;
    }



    public static double[] randomDoubleArray(int length, double lowerBound, double range) {
        double[] v = new double[length];
        Random r = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = lowerBound + range * r.nextDouble();
        }
        return v;
    }

}