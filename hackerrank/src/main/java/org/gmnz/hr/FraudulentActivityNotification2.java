package org.gmnz.hr;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;


public class FraudulentActivityNotification2 {

    private static final int MAX_EXPENSE = 200;

    // o o o o o o o o o o
    // 0 1 2 3 4 5 6 7 8 9

    static int activityNotifications(int[] expenditure, int d) {

        int notifications = 0;

        Queue<Integer> q = new ArrayBlockingQueue<>(d);

        for (int i = 0; i < d; i++) {
            q.add(expenditure[i]);
        }

        int[] counts = new int[MAX_EXPENSE + 1];
        int[] sums = new int[MAX_EXPENSE + 1];

        for (int x : q) {
            counts[x]++;
        }

        updateSums(counts, sums, 0);

        int k = d;

        notifications += expenditure[k] >= 2 * countingSortWmedian(q, d, sums) ? 1 : 0;

        while (k < expenditure.length - 1) {
            int expRemoved = q.remove();
            int expInserted = expenditure[k];
            q.add(expInserted);
            counts[expRemoved]--;
            counts[expInserted]++;

            updateSums(counts, sums, Math.min(expRemoved, expInserted));

            k++;
            notifications += expenditure[k] >= 2 * countingSortWmedian(q, d, sums) ? 1 : 0;
        }

        return notifications;
    }



    private static void updateSums(int[] counts, int[] sums, int fromIndex) {
        sums[0] = counts[0];
        for (int i = fromIndex + 1; i < counts.length; i++)
            sums[i] = sums[i - 1] + counts[i];
    }



    private static double countingSortWmedian(Iterable<Integer> q, int l, int[] sums) {
        Map<Integer, Integer> mm = new HashMap<>();
        double result = -1;
        if (l % 2 == 0) {
            boolean b1 = false;
            boolean b2 = false;
            int x1 = -1;
            int x2 = -1;
            for (int x : q) {
                sums[x] -= 1;
                if (!mm.containsKey(x)) {
                    mm.put(x, 1);
                } else {
                    mm.put(x, mm.get(x) + 1);
                }
                if (sums[x] == l / 2) {
                    x1 = x;
                    b1 = true;
                }
                if (sums[x] == 1 + l / 2) {
                    x2 = x;
                    b2 = true;
                }
                if (b1 && b2) {
                    result = ((double) (x1 + x2)) / 2;
                    break;
                }
            }
        } else {
            for (int x : q) {
                sums[x] -= 1;
                if (!mm.containsKey(x)) {
                    mm.put(x, 1);
                } else {
                    mm.put(x, mm.get(x) + 1);
                }
                if (sums[x] == l / 2) {
                    result = x;
                    break;
                }
            }
        }
        for (Integer x : mm.keySet()) {
            sums[x] += mm.get(x);
        }
        return result;
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