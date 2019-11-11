package org.gmnz.ddi.algs.sorting;


import java.util.Random;


/**
 * ArrayUtils
 */
public final class ArrayUtils {

    private ArrayUtils() {}



    /**
     * Rappresenta in strina un array di <code>byte</code>
     * 
     * @param v array di byte
     * @return rappresentazione in stringa
     */
    public static String toString(byte[] v) {
        StringBuilder sb = new StringBuilder("[");
        for (byte b : v) {
            sb.append(String.format("%6d", b));
        }
        sb.append(" ]");
        return sb.toString();
    }



    /**
     * * Rappresenta in strina un array di <code>int</code>
     * 
     * @param v array di interi
     * @return rappresentazione in stringa
     */
    public static String toString(int[] v) {
        double dblHighestMagnitude = 0;
        for (int x : v) {
            double dblMag = Math.log10(Math.abs(x));
            if (dblMag > dblHighestMagnitude)
                dblHighestMagnitude = dblMag;
        }
        dblHighestMagnitude = Math.ceil(dblHighestMagnitude);
        final int MAX_SPACING = 4;
        int spacing = Double.valueOf(Math.round(dblHighestMagnitude / 1.618)).intValue();
        if (spacing > MAX_SPACING)
            spacing = MAX_SPACING;
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



    /**
     * Controlla se un array di <code>int</code> è ordinato. Un array è ordinato se
     * e solo se ogni elemento (a parte l'ultimo) è non maggiore del successivo.
     * <p>
     * Gli array nulli, quelli di lunghezza 0 o 1 sono considerati ordinati.
     * 
     * @param v array di <code>int</code>
     * @return {@code true} se {@code v} è ordinato, nullo o ha lunghezza
     * strettamente minore di 2, altrimenti {@code false}
     */
    public static boolean isSorted(int[] v) {
        // array nulli e di lunghezza 0 o 1 sono considerati ordinati
        if (v == null || v.length < 2)
            return true;
        int i = 1;
        while (i < v.length) {
            if (v[i] < v[i - 1])
                // se un elemento è maggiore del successivo, l'array non è ordinato
                return false;
            i++;
        }
        return true;
    }



    /**
     * Controlla se un array di oggetti {@link Comparable} è ordinato. Un array è
     * ordinato se e solo se ogni elemento (a parte l'ultimo) è non maggiore del
     * successivo.
     * <p>
     * Gli array nulli, quelli di lunghezza 0 o 1 sono considerati ordinati.
     * 
     * @param v array di {@link Comparable}
     * @return {@code true} se {@code v} è ordinato, nullo o ha lunghezza
     * strettamente minore di 2, altrimenti {@code false}
     * 
     */
    public static <K extends Comparable<K>> boolean isSorted(K[] v) {
        if (v == null || v.length < 2)
            return true;
        int i = 1;
        while (i < v.length) {
            if (v[i].compareTo(v[i - 1]) < 0)
                return false;
            i++;
        }
        return true;
    }



    /**
     * Genera un array di numeri interi (pseudo) casuali. Si specifica la lunghezza
     * dell'array; i valori dell'array sono nell'intervallo [low, high[ (aperto a
     * dx).
     * <p>
     * Specificando lunghezze negative si ottiene un {@code null}. Specificando
     * lunghezza 0 si ottiene un array vuoto.
     * 
     * @param length lunghezza richiesta dell'array
     * @param lowerBound valore minimo (incluso)
     * @param upperBound valore massimo (escluso)
     * @return array di numeri interi casuali
     */
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
            v[i] = lowerBound + r.nextInt(Math.abs(upperBound - lowerBound));
        }
        return v;
    }



    /**
     * Analogo di {@link #randomIntArray(int, int, int)}, ma che usa oggetti
     * {@link Integer}
     * 
     */
    public static Integer[] randomIntegerArray(int length, int lowerBound, int upperBound) {
        if (length < 0)
            return null;
        if (length == 0)
            return new Integer[] {};
        Integer[] v = new Integer[length];
        Random r = new Random();
        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        for (int i = 0; i < v.length; i++) {
            v[i] = lowerBound + r.nextInt(Math.abs(upperBound - lowerBound));
        }
        return v;
    }



    /**
     * Array di {@code double} pseudo casuali. Si specifica il valore minimo e
     * l'ampiezza dell'intervallo. Ogni elemento dell'array generato è
     * nell'intervallo {@code [lowerBound..lowerBound+range[}.
     * <p>
     * Valori di {@code length} minori di 0 risultano in un {@code null}; se
     * {@code length == 0} viene restituito un array vuoto.
     * <p>
     * A titolo cautelativo, internamente viene usato {@code Math.abs(range)}.
     * 
     * @param length lunghezza array
     * @param lowerBound valore minimo
     * @param range estensione massima
     * @return array di {@code double} casuali
     */
    public static double[] randomDoubleArray(int length, double lowerBound, double range) {
        if (length < 0)
            return null;
        if (length == 0)
            return new double[] {};
        double[] v = new double[length];
        Random r = new Random();
        range = Math.abs(range);
        for (int i = 0; i < v.length; i++) {
            v[i] = lowerBound + range * r.nextDouble();
        }
        return v;
    }

}