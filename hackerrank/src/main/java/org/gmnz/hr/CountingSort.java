package org.gmnz.hr;


import java.util.Random;


/**
 * CountingSort - implementazione mia
 */
public class CountingSort {

    private int[] sumCount;
    private int[] v;

    public CountingSort(int[] v) {
        int max = -1;
        for (int x : v) {
            if (max < x) {
                max = x;
            }
        }
        max = Math.max(max, v.length);
        sumCount = new int[max + 1];
        for (int x : v) {
            sumCount[x] += 1;
        }
        for (int i = 1; i <= max; i++) {
            sumCount[i] += sumCount[i - 1];
        }
        this.v = v;
    }



    int[] sort() {
        int[] vsorted = new int[v.length];
        for (int x : v) {
            vsorted[sumCount[x]] = x;
            sumCount[x] -= 1;
        }
        return vsorted;
    }



    private static String arrayToString(int[] v) {
        StringBuilder sb = new StringBuilder("[");
        for (int x : v) {
            sb.append(String.format("%4d", x));
        }
        sb.append("  ]");
        return sb.toString();
    }



    public static void main(String[] args) {
        Random r = new Random();
        final int L = 20;
        final int UPPER_BOUND = 20;
        int[] v = new int[L];
        for (int i = 0; i < L; i++) {
            v[i] = r.nextInt(UPPER_BOUND);
        }
        System.out.println(arrayToString(v));
        CountingSort cs = new CountingSort(v);
        int[] vsorted = cs.sort();
        System.out.println(arrayToString(vsorted));
    }

}