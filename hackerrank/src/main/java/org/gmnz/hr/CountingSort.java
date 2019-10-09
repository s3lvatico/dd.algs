package org.gmnz.hr;


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

        sumCount = new int[max + 1];

        for (int x : v) {
            sumCount[x] += 1;
        }

        for (int i = 1; i < sumCount.length; i++) {
            sumCount[i] += sumCount[i - 1];
        }

        this.v = v;
    }



    int[] sort() {
        int[] vsorted = new int[v.length];
        for (int x : v) {
            int s = sumCount[x] - 1;
            vsorted[s] = x;
            sumCount[x] -= 1;
        }
        return vsorted;
    }

}