package org.gmnz.ddi.algs.sorting;


import java.util.Random;


/**
 * ArrayUtils
 */
public class ArrayUtils {

    private ArrayUtils() {
    }



    /**
     * 
     * @param  v array di byte
     * @return   rappresentazione in stringa
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
     * 
     * @param  v array di interi
     * @return   rappresentazione in stringa
     */
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



    /**
     * Controlla se un array di interi è ordinato - se ogni elemento è maggiore o
     * uguale del precedente.
     * <p>
     * Gli array nulli, quelli di lunghezza 0 o 1 sono considerati ordinati.
     * 
     * @param  v array di interi
     * @return   {@code true} se {@code v} è ordinato, nullo o ha lunghezza
     *           strettamente minore di 2, altrimenti {@code false}
     */
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



    /**
     * Genera un array di numeri interi (pseudo) casuali. Si specifica la lunghezza
     * dell'array; i valori dell'array sono nell'intervallo [low, high[ (aperto a
     * dx).
     * <p>
     * Specificando lunghezze negative si ottiene un {@code null}. Specificando
     * lunghezza 0 si ottiene un array vuoto.
     * 
     * @param  length     lunghezza richiesta dell'array
     * @param  lowerBound valore minimo (incluso)
     * @param  upperBound valore massimo (escluso)
     * @return            array di numeri interi casuali
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
     * Array di {@code double} pseudo casuali. Si specifica il valore minimo e
     * l'ampiezza dell'intervallo. Ogni elemento dell'array generato è
     * nell'intervallo {@code [lowerBound..lowerBound+range[}.
     * <p>
     * Valori di {@code length} minori di 0 risultano in un {@code null}; se
     * {@code length == 0} viene restituito un array vuoto.
     * <p>
     * A titolo cautelativo, internamente viene usato {@code Math.abs(range)}.
     * 
     * @param  length     lunghezza array
     * @param  lowerBound valore minimo
     * @param  range      estensione massima
     * @return            array di {@code double} casuali
     */
    public static double[] randomDoubleArray(int length, double lowerBound, double range) {
        if (length < 0)
            return null;
        if (length == 0)
            return new double[] {};
        double[] v = new double[length];
        Random r = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = lowerBound + Math.abs(range) * r.nextDouble();
        }
        return v;
    }

}