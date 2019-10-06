package org.gmnz.hr;


import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;


public class FraudulentActivityNotification2 {

    private static final int MAX_EXPENSE = 200;

    static int activityNotifications(int[] expenditure, int d) {

        int notifications = 0;

        Queue<Integer> q = new ArrayBlockingQueue<>(d);

        for (int i = 0; i < d; i++) {
            q.add(expenditure[i]);
        }

        // per il counting sort ho bisogno degli indici fino a maxValue
        int[] counts = new int[MAX_EXPENSE];
        int[] sums = new int[MAX_EXPENSE];

        for (int x : q) {
            counts[x]++;
        }

        updateSums(counts, sums, 0);

        int[] sortedWindow = countingSort(q, d, Arrays.copyOf(sums, sums.length));

        int k = d;

        notifications += expenditure[k] >= 2 * median(sortedWindow) ? 1 : 0;

        while (k < expenditure.length - 1) {
            int expRemoved = q.remove();
            int expInserted = expenditure[k];
            q.add(expInserted);
            counts[expRemoved]--;
            counts[expInserted]++;

            // int minIndex = Math.min(expInserted, expRemoved);
            // sums[expRemoved]--;

            updateSums(counts, sums, 0);

            sortedWindow = countingSort(q, d, sums);
            k++;
            notifications += expenditure[k] >= 2 * median(sortedWindow) ? 1 : 0;
        }

        return notifications;
    }



    private static void updateSums(int[] counts, int[] sums, int fromIndex) {
        sums[0] = counts[0];
        for (int i = fromIndex + 1; i < counts.length; i++)
            sums[i] = sums[i - 1] + counts[i];
    }



    private static int[] countingSort(Iterable<Integer> q, int d, int[] sums) {
        int[] sorted = new int[d];
        for (int x : q) {
            sums[x] -= 1;
            sorted[sums[x]] = x;
        }
        return sorted;
    }



    private static double median(int[] v) {
        int l = v.length;
        if (l % 2 == 1) {
            // . . . . . . .
            return (double) v[l / 2];
        } else {
            // . . . . . . . .
            return ((double) v[l / 2] + v[l / 2 + 1]) / 2;
        }
    }



    private static void print(int[] v) {
        StringBuilder sb = new StringBuilder("[");
        for (int x : v) {
            sb.append(String.format("%4d", x));
        }
        sb.append("  ]");
        System.out.println(sb.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}